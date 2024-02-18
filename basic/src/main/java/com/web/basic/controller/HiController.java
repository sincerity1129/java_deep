package com.web.basic.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.web.basic.domain.greeting.Greeting;
import com.web.basic.mapper.GreetingMapper;
import com.web.basic.service.GreetingService;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class HiController {
    private final GreetingService greetingService;
    private final GreetingMapper greetingMapper;

    @GetMapping("hello/{name}")
    public String hello(@PathVariable String name) {
        return greetingService.printHello(name);
    }
    @GetMapping("hello/list")
    public List<Greeting> greeingAll() {
        return greetingService.greetingListAll();
    }    
    @GetMapping("hello/list/name")
    public List<Greeting> greeingDetailName(@RequestParam String name) {
        return greetingService.greetingListName(name);
    }
    @GetMapping("hello/list/content")
    public List<Greeting> greeingDetailContent(@RequestParam String content) {
        return greetingService.greetingListContent(content);
    }      

    @GetMapping("hello/ibatis")
    public List<Greeting> greeingIbatis() {
        return greetingMapper.listGreeting();
    }    
}
