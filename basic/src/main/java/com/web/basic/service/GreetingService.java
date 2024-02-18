package com.web.basic.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.web.basic.domain.greeting.Greeting;
import com.web.basic.domain.greeting.GreetingRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GreetingService {
    private final GreetingRepository greetingRepository;

    public String printHello(String name) {
        return "hello "+name;
    }

    public List<Greeting> greetingListAll() {
        return greetingRepository.findAll();
    }

    public List<Greeting> greetingListName(String name) {
        return greetingRepository.findByName(name);
    }

    public List<Greeting> greetingListContent(String content) {
        return greetingRepository.findByContent(content);
    }
}
