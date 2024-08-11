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
public class DecipherService {

    private final Gson gson = new GsonBuilder().disableHtmlEscaping().create();
    private final Criptografic criptografic = new Criptografic();

    public Object validateObject(Object encryptedValueToJSON) {
        JsonElement jsonElement = parseToJsonElement(encryptedValueToJSON);
        if (jsonElement != null) {
            return handleJsonElement(jsonElement, encryptedValueToJSON);
        }
        return encryptedValueToJSON;
    }

    private Map<String, Object> decryptMap(Map<String, Object> map) {
        Map<String, Object> decryptedMap = new HashMap<>();
        map.forEach((key, value) -> decryptedMap.put(key, decryptObject(value)));
        return decryptedMap;
    }

    private List<Object> decryptList(List list) {
        List<Object> decryptedList = new ArrayList<>();
        list.forEach(element -> decryptedList.add(decryptObject(element)));
        return decryptedList;
    }

    private Object decryptObject(Object value) {
        if (Objects.nonNull(value)) {
            if (value instanceof Map) {
                return decryptMap((Map<String, Object>) value);
            } else if (value instanceof List) {
                return decryptList((List) value);
            } else if (value instanceof String) {
                return decryptString((String) value);
            }
        }
        return value;
    }

    private String decryptString(String value) {
        try {
            return criptografic.decipher(value);
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
                return gson.toJson(decryptMap(map));
            } else if (jsonElement.isJsonArray()) {
                List list = gson.fromJson(jsonElement.getAsJsonArray(), List.class);
                return gson.toJson(decryptList(list));
            }
        } catch (Exception e) {
            info("Error decrypting the data");
        }
        return originalValue;
    }
}