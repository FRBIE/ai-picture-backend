package com.xrp.aipicturebackend;

import com.xrp.aipicturebackend.service.PictureService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class AiPictureBackendApplicationTests {
    @Resource
    private PictureService pictureService;
    @Test
    void contextLoads() {
        String s = pictureService.extractObjectKeyFromUrl("https://ai-picture-xxxxxxx.cos.ap-xxxxx.myqcloud.com/public/1899378329551446017/2025-03-24_GQkANqwAf7nMJOqi.webp");
        System.out.println(s);
    }

}
