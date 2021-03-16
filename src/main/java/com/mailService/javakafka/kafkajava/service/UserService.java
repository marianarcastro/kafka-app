package com.mailService.javakafka.kafkajava.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mailService.javakafka.kafkajava.entity.Users;
import com.mailService.javakafka.kafkajava.repository.UserRepository;



@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	
	public List<Users> findAll() {
		return repository.findAll();
	}
	
}
