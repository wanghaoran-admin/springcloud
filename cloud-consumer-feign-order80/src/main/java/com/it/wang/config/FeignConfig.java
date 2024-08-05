package com.it.wang.config;

import feign.Logger;
import feign.Retryer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {

    // 重试机制
    @Bean
    public Retryer myRetryer() {
//       return new Retryer.Default();
       return new Retryer.Default(100, 1, 3);
    }

//     日志记录级别
    @Bean
    public Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
}
