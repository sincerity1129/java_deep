package com.web.basic.domain.greeting;

import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GreetingRepository extends JpaRepository<Greeting, UUID>{
    List<Greeting> findByName(String name);
    List<Greeting> findByContent(String content);
}
