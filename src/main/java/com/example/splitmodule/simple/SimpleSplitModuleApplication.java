package com.example.splitmodule.simple;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

import java.util.concurrent.CountDownLatch;

@Slf4j
@SpringBootApplication(scanBasePackages ="com.example.splitmodule.simple" )
@ImportResource("classpath:spring/spring-main.xml")
public class SimpleSplitModuleApplication {

    public static void main(String[] args) {

        SpringApplication.run(SimpleSplitModuleApplication.class, args);
        CountDownLatch latch = new CountDownLatch(1);
        try {
            latch.await();
        } catch (InterruptedException e) {
            log.error("Application latch.await InterruptedException", e);
            Thread.currentThread().interrupt();
        }
    }

}
