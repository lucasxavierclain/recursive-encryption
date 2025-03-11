package com.example.recursive.encryption.config;

import io.github.bucket4j.Bucket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class RateLimitConfigTest {

    private RateLimitConfig rateLimitConfig;

    @BeforeEach
    public void setUp() {
        rateLimitConfig = new RateLimitConfig();
        ReflectionTestUtils.setField(rateLimitConfig, "refillTokens", 10);
        ReflectionTestUtils.setField(rateLimitConfig, "refillDuration", Duration.ofMinutes(1));
    }

    @Test
    public void testBucketBean() {
        Bucket bucket = rateLimitConfig.bucket();
        assertNotNull(bucket);
    }
}