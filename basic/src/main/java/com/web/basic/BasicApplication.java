package com.web.basic;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.web.basic.domain.greeting.Greeting;
import com.web.basic.domain.greeting.GreetingRepository;
import com.web.basic.domain.user.User;
import com.web.basic.domain.user.UserRepository;
import com.web.basic.service.AuthService;

import lombok.RequiredArgsConstructor;

@SpringBootApplication
@RequiredArgsConstructor
public class BasicApplication implements CommandLineRunner {
	private final GreetingRepository greetingRepository;
	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(BasicApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<Greeting> greetingList = List.of(
            new Greeting( UUID.randomUUID(), "test1", "hi", LocalDateTime.now()),
            new Greeting( UUID.randomUUID(), "test2", "second", LocalDateTime.now()),
			new Greeting( UUID.randomUUID(), "test3", "third", LocalDateTime.now())
        	);
		for (Greeting g : greetingList) {
			greetingRepository.save(g);
		}

		List<User> userList = List.of(
			User.builder()
			.email("tester@test.com")
			.password(passwordEncoder.encode("1234"))
			.name("tester")
			.build()
		);

		greetingRepository.saveAll(greetingList);
		userRepository.saveAll(userList);
	}
}
