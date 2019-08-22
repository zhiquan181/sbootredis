package com.zhiquan.cai.sbootredis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class SbootredisApplication {

    public static void main(String[] args) {
        SpringApplication.run(SbootredisApplication.class, args);
    }

}
