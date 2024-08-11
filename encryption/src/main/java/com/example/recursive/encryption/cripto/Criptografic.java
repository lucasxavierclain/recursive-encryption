package com.example.recursive.encryption.cripto;

import java.nio.charset.StandardCharsets;

import java.util.Base64;

public class Criptografic {


    public String decipher(String encryptedValue){
        return new String(Base64.getDecoder().decode(encryptedValue));
    }

    public String cipher(String value){
        return 	new String(Base64.getEncoder().encode(value.getBytes(StandardCharsets.UTF_8)));	}
}