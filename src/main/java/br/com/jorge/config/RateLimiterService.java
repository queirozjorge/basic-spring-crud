package br.com.jorge.config;

import io.github.resilience4j.ratelimiter.RateLimiter;
import io.github.resilience4j.ratelimiter.RateLimiterConfig;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Service
public class RateLimiterService {

    private final RateLimiter rateLimiter;

    public RateLimiterService() {
        RateLimiterConfig config = RateLimiterConfig.custom()
            .limitForPeriod(1)
            .limitRefreshPeriod(Duration.ofSeconds(5))
            .timeoutDuration(Duration.ofMillis(500))
            .build();

        rateLimiter = RateLimiter.of("myRateLimiter", config);
    }

    public boolean accessApiEndpoint() {

        return rateLimiter.acquirePermission();

    }

}
