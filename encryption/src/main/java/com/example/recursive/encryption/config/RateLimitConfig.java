package com.example.recursive.encryption.config;


import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.Bucket;
import io.github.bucket4j.Bucket4j;
import io.github.bucket4j.Refill;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.time.Duration;

@Configuration
public class RateLimitConfig implements WebMvcConfigurer {


        @Value("${rate.limiter.refill}")
        private int refillTokens;

        @Value("${rate.limiter.duration}")
        private Duration refillDuration;

    @Bean
    public Bucket bucket() {
        Bandwidth limit = Bandwidth.classic(refillTokens, Refill.greedy(refillTokens, refillDuration));
        return Bucket4j.builder().addLimit(limit).build();
    }
    }