package com.xrp.aipicturebackend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@MapperScan("com.xrp.aipicturebackend.mapper")
@EnableAspectJAutoProxy(exposeProxy = true)
public class AiPictureBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(AiPictureBackendApplication.class, args);
    }

}
