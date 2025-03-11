package com.example.recursive.encryption.services;

import com.example.recursive.encryption.cripto.Criptografic;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class DecipherServiceTest {

    private DecipherService decipherService;
    private Criptografic criptografic;

    @BeforeEach
    public void setUp() {
        criptografic = Mockito.mock(Criptografic.class);
        decipherService = new DecipherService();
        ReflectionTestUtils.setField(decipherService, "criptografic", criptografic);
    }

    @Test
    public void testValidateObject_withValidJson() {
        String json = "{\"key\":\"value\"}";
        Object result = decipherService.validateObject(json);
        assertNotNull(result);
    }

    @Test
    public void testDecryptString() throws Exception {
        String value = "encrypted";
        Mockito.when(criptografic.decipher(value)).thenReturn("decrypted");
        String result = decipherService.decryptString(value);
        assertEquals("decrypted", result);
    }
}