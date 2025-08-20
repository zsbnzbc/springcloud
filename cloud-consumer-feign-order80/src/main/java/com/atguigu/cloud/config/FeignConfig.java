package com.atguigu.cloud.config;

import feign.Logger;
import feign.Retryer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lyh
 * @date 2025/8/20
 */
@Configuration
public class FeignConfig
{
    @Bean
    public Retryer myRetryer()
    {
        //Feign默认配置是不走重试策略的
//        return Retryer.NEVER_RETRY;

        //最大请求次数为3(1+2)，初始间隔时间为100ms，重试间最大间隔时间为1s
        return new Retryer.Default(100,1,3);
    }

    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
}
