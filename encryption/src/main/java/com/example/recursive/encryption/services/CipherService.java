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

    private final Gson gson = new GsonBuilder().disableHtmlEscaping().create();
    private final Criptografic criptografic = new Criptografic();

    public Object validateObject(Object encryptedValueToJSON) {
        JsonElement jsonElement = parseToJsonElement(encryptedValueToJSON);
        if (jsonElement != null) {
            return handleJsonElement(jsonElement, encryptedValueToJSON);
        }
        return encryptedValueToJSON;
    }

    private Map<String, Object> encryptMap(Map<String, Object> map) {
        Map<String, Object> encryptedMap = new HashMap<>();
        map.forEach((key, value) -> encryptedMap.put(key, encryptObject(value)));
        return encryptedMap;
    }

    private List<Object> encryptList(List list) {
        List<Object> encryptedList = new ArrayList<>();
        list.forEach(element -> encryptedList.add(encryptObject(element)));
        return encryptedList;
    }

    private Object encryptObject(Object value) {
        if (Objects.nonNull(value)) {
            if (value instanceof Map) {
                return encryptMap((Map<String, Object>) value);
            } else if (value instanceof List) {
                return encryptList((List) value);
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
                return gson.toJson(encryptMap(map));
            } else if (jsonElement.isJsonArray()) {
                List list = gson.fromJson(jsonElement.getAsJsonArray(), List.class);
                return gson.toJson(encryptList(list));
            }
        } catch (Exception e) {
            info("Error encrypting data");
        }
        return originalValue;
    }
}