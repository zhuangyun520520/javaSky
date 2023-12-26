package com.sky.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
@Slf4j
public class RedisConfiguration {
    //通过redis模板对象可以操作redis
    @Bean
    public RedisTemplate redisTemplate(RedisConnectionFactory redisConnectionFactory){
        log.info("开始创建redis模板对象........");

        RedisTemplate redisTemplate = new RedisTemplate();
        //设置redis的连接工厂
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        //设置redis key的序列化器,不设置的话，redis的图形化界面显示的key不是String
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        return redisTemplate;

    }
}
