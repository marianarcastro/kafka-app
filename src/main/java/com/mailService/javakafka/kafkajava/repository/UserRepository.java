package com.mailService.javakafka.kafkajava.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mailService.javakafka.kafkajava.entity.Users;


public interface UserRepository extends JpaRepository<Users, Integer>{

}
