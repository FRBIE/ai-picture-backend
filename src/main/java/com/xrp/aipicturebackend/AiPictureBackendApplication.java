package com.xrp.aipicturebackend;

import org.apache.shardingsphere.spring.boot.ShardingSphereAutoConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication(exclude = {ShardingSphereAutoConfiguration.class})//分库分表逻辑复杂，另外需要补充公共图库spaceId不能为null的逻辑，暂时不应用
@MapperScan("com.xrp.aipicturebackend.mapper")
@EnableAspectJAutoProxy(exposeProxy = true)
@EnableAsync
public class AiPictureBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(AiPictureBackendApplication.class, args);
    }

}
