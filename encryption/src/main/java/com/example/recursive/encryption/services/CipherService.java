package com.example.recursive.encryption.services;

import com.example.recursive.encryption.cripto.Criptografic;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;



import org.springframework.stereotype.Service;

import java.util.*;

import static org.slf4j.helpers.Reporter.info;


@Service
public class CipherService {

    private static final int MAX_DEPTH = 64;
    private final Gson gson = new GsonBuilder().disableHtmlEscaping().create();
    private final Criptografic criptografic = new Criptografic();

    public Object validateObject(Object encryptedValueToJSON) {
        JsonElement jsonElement = parseToJsonElement(encryptedValueToJSON);
        if (jsonElement != null) {
            return handleJsonElement(jsonElement, encryptedValueToJSON);
        }
        return encryptedValueToJSON;
    }

    private Map<String, Object> encryptMap(Map<String, Object> map, int depth) {
        if (depth > MAX_DEPTH) {
            throw new IllegalArgumentException("Input exceeds maximum nesting depth of " + MAX_DEPTH);
        }
        Map<String, Object> encryptedMap = new HashMap<>();
        map.forEach((key, value) -> encryptedMap.put(key, encryptObject(value, depth + 1)));
        return encryptedMap;
    }

    private List<Object> encryptList(List list, int depth) {
        if (depth > MAX_DEPTH) {
            throw new IllegalArgumentException("Input exceeds maximum nesting depth of " + MAX_DEPTH);
        }
        List<Object> encryptedList = new ArrayList<>();
        list.forEach(element -> encryptedList.add(encryptObject(element, depth + 1)));
        return encryptedList;
    }

    private Object encryptObject(Object value, int depth) {
        if (Objects.nonNull(value)) {
            if (value instanceof Map) {
                return encryptMap((Map<String, Object>) value, depth);
            } else if (value instanceof List) {
                return encryptList((List) value, depth);
            } else if (value instanceof String) {
                return encryptString((String) value);
            }
        }
        return value;
    }

    String encryptString(String value) {
        try {
            return criptografic.cipher(value);
        } catch (Exception e) {
            return value;
        }
    }

    private JsonElement parseToJsonElement(Object encryptValueToJSON) {
        try {
            if (encryptValueToJSON instanceof String) {
                return JsonParser.parseString((String) encryptValueToJSON);
            } else {
                return JsonParser.parseString(gson.toJson(encryptValueToJSON));
            }
        } catch (Exception e) {
            return null;
        }
    }

    private Object handleJsonElement(JsonElement jsonElement, Object originalValue) {
        try {
            if (jsonElement.isJsonObject()) {
                Map map = gson.fromJson(jsonElement, Map.class);
                return gson.toJson(encryptMap(map, 0));
            } else if (jsonElement.isJsonArray()) {
                List list = gson.fromJson(jsonElement.getAsJsonArray(), List.class);
                return gson.toJson(encryptList(list, 0));
            }
        } catch (Exception e) {
            info("Error encrypting data");
        }
        return originalValue;
    }
}
