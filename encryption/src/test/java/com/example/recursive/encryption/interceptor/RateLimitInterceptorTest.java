package com.example.recursive.encryption.interceptor;

import io.github.bucket4j.Bucket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class RateLimitInterceptorTest {

    private Bucket bucket;
    private RateLimitInterceptor rateLimitInterceptor;

    @BeforeEach
    public void setUp() {
        bucket = Mockito.mock(Bucket.class);
        rateLimitInterceptor = new RateLimitInterceptor(bucket);
    }

    @Test
    public void testPreHandle_whenBucketAllows_shouldReturnTrue() throws Exception {
        when(bucket.tryConsume(1)).thenReturn(true);

        MockHttpServletRequest request = new MockHttpServletRequest();
        MockHttpServletResponse response = new MockHttpServletResponse();

        boolean result = rateLimitInterceptor.preHandle(request, response, new Object());

        assertTrue(result);
    }

    @Test
    public void testPreHandle_whenBucketDenies_shouldReturnFalse() throws Exception {
        when(bucket.tryConsume(1)).thenReturn(false);

        MockHttpServletRequest request = new MockHttpServletRequest();
        MockHttpServletResponse response = new MockHttpServletResponse();

        boolean result = rateLimitInterceptor.preHandle(request, response, new Object());

        assertFalse(result);
        assertEquals(429, response.getStatus());
    }
}