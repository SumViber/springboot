package com.sumvibe.springboot.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @date: 2023/8/30 14:34:56
 * @author: xuxufu
 * @description:
 */
@RestController
@Slf4j
public class AjaxTest {
    @GetMapping(value = "/receiveReq")
    public String receiveReq() {
        return System.currentTimeMillis()+": 收到前端请求了...";
    }
}
