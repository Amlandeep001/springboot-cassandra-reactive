package com.example.cassandra.reactive.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.cassandra.reactive.model.User;
import com.example.cassandra.reactive.repository.UserRepository;

import jakarta.annotation.PostConstruct;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class UserController
{
	private final UserRepository userRepository;

	public UserController(UserRepository userRepository)
	{
		this.userRepository = userRepository;
	}

	@PostConstruct
	public void saveUser()
	{
		List<User> users = new ArrayList<>();
		users.add(new User(6437, "Basant", "Bangalore", 50));
		users.add(new User(3523, "Saroj", "Pune", 20));
		users.add(new User(8694, "Ravindra", "Mumbai", 30));
		users.add(new User(9854, "Samas", "Odisha", 25));

		Flux<User> savedUsers = userRepository.saveAll(users);
		savedUsers.subscribe();
	}

	@GetMapping("/getUsers")
	public Flux<User> getUsers()
	{
		return userRepository.findAll();
	}

	@GetMapping("/getUsersByAge/{age}")
	public Flux<User> getUserByAge(@PathVariable int age)
	{
		return userRepository.findByAgeLessThan(age);
	}

	@GetMapping("/getUser/{address}")
	public Mono<User> getUser(@PathVariable String address)
	{
		return userRepository.findByAddress(address);
	}
}
