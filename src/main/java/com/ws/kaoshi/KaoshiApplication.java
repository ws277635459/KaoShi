package com.ws.kaoshi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.ws.kaoshi.dao")
public class KaoshiApplication {

    public static void main(String[] args) {
        SpringApplication.run(KaoshiApplication.class, args);
    }

}
