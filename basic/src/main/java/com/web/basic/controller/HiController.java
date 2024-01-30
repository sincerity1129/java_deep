package com.web.basic.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.basic.service.TestService;

@RestController
@RequestMapping("/")
public class HiController {
    final TestService testService;

    public HiController (TestService testService) {
        this.testService = testService;
    }

    @GetMapping("hello")
    public String hello() {
        return testService.printHello();
    }
}
