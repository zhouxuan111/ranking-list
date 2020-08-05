package com.zx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class RankingListApplication {

    public static void main(String[] args) {
        SpringApplication.run(RankingListApplication.class, args);
    }

}
