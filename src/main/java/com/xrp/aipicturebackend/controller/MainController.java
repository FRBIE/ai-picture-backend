package com.xrp.aipicturebackend.controller;

import com.xrp.aipicturebackend.common.BaseResponse;
import com.xrp.aipicturebackend.common.ResultUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class MainController {
    @GetMapping("/health")
    public BaseResponse<String> testHealth() {
        return ResultUtils.success("OK");
    }
}
