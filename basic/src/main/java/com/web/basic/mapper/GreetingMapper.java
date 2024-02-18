package com.web.basic.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.web.basic.domain.greeting.Greeting;

import java.util.List;

@Mapper
public interface GreetingMapper {
    public List<Greeting> listGreeting();
}
