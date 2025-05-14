package com.korit.vocard.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * class: Redis 설정 클래스
 * 
 * description: Redis 연결 및 템플릿 설정을 담당합니다.
 */
@Configuration
public class RedisConfig {

    /**
     * description: Redis 템플릿 설정
     * 
     * <p>
     * <ul>
     * <li>키와 값 모두 String 타입으로 직렬화</li>
     * <li>토큰 블랙리스트 저장에 사용</li>
     * </ul>
     * </p>
     *
     * @param connectionFactory Redis 연결 팩토리
     * @return 설정된 RedisTemplate
     */
    @Bean
    public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory connectionFactory) {
        RedisTemplate<String, String> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(connectionFactory);
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new StringRedisSerializer());
        return redisTemplate;
    }
} 