package com.bogdyMusicLover;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class StockWeb {
    public static void main(String[] args) {
        SpringApplication.run(StockWeb.class, args);
    }
}
