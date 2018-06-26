package com.wangcai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class WangcaiApplication {

    public static void main(String[] args) {
        SpringApplication.run(WangcaiApplication.class, args);
    }
}
