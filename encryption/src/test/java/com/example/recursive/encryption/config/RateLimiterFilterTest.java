package com.example.recursive.encryption.config;

import io.github.bucket4j.Bucket;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.mock.web.MockFilterChain;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class RateLimiterFilterTest {

    private Bucket bucket;
    private RateLimiterFilter rateLimiterFilter;

    @BeforeEach
    public void setUp() {
        bucket = Mockito.mock(Bucket.class);
        rateLimiterFilter = new RateLimiterFilter();
        rateLimiterFilter.bucket = bucket;
    }

    @Test
    public void testDoFilterInternal_whenBucketAllows_shouldProceed() throws ServletException, IOException {
        when(bucket.tryConsume(1)).thenReturn(true);

        MockHttpServletRequest request = new MockHttpServletRequest();
        MockHttpServletResponse response = new MockHttpServletResponse();
        FilterChain filterChain = new MockFilterChain();

        rateLimiterFilter.doFilterInternal(request, response, filterChain);

        assertEquals(200, response.getStatus());
    }

    @Test
    public void testDoFilterInternal_whenBucketDenies_shouldReturnTooManyRequests() throws ServletException, IOException {
        when(bucket.tryConsume(1)).thenReturn(false);

        MockHttpServletRequest request = new MockHttpServletRequest();
        MockHttpServletResponse response = new MockHttpServletResponse();
        FilterChain filterChain = new MockFilterChain();

        rateLimiterFilter.doFilterInternal(request, response, filterChain);

        assertEquals(429, response.getStatus());
        assertEquals("Too many requests", response.getContentAsString());
    }
}