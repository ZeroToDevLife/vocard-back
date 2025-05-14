package com.korit.vocard.repository;

import java.util.concurrent.TimeUnit;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;

/**
 * class: 블랙리스트 토큰 저장소
 * 
 * description: 로그아웃된 토큰을 Redis에 저장하여 관리합니다.
 */
@Repository
@RequiredArgsConstructor
public class BlacklistTokenRepository {

    private final RedisTemplate<String, String> redisTemplate;
    private static final String KEY_PREFIX = "blacklist:";

    /**
     * description: 토큰을 블랙리스트에 추가
     *
     * @param token JWT 토큰
     * @param timeToLiveSeconds 만료까지 남은 시간(초)
     */
    public void addToBlacklist(String token, long timeToLiveSeconds) {
        String key = KEY_PREFIX + token;
        redisTemplate.opsForValue().set(key, "true", timeToLiveSeconds, TimeUnit.SECONDS);
    }

    /**
     * description: 토큰이 블랙리스트에 있는지 확인
     *
     * @param token 확인할 JWT 토큰
     * @return 블랙리스트에 있으면 true, 없으면 false
     */
    public boolean isBlacklisted(String token) {
        String key = KEY_PREFIX + token;
        return Boolean.TRUE.equals(redisTemplate.hasKey(key));
    }
} 