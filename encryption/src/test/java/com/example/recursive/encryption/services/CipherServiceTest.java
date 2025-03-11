package com.example.recursive.encryption.services;

import com.example.recursive.encryption.cripto.Criptografic;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.test.util.ReflectionTestUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CipherServiceTest {

    private CipherService cipherService;
    private Criptografic criptografic;

    @BeforeEach
    public void setUp() {
        criptografic = Mockito.mock(Criptografic.class);
        cipherService = new CipherService();
        ReflectionTestUtils.setField(cipherService, "criptografic", criptografic);
    }

    @Test
    public void testValidateObject_withValidJson() {
        String json = "{\"key\":\"value\"}";
        Object result = cipherService.validateObject(json);
        assertNotNull(result);
    }

    @Test
    public void testEncryptString() throws Exception {
        String value = "test";
        Mockito.when(criptografic.cipher(value)).thenReturn("encrypted");
        String result = cipherService.encryptString(value);
        assertEquals("encrypted", result);
    }
}