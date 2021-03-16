package com.mailService.javakafka.kafkajava;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;




@EnableKafka
@SpringBootApplication
public class KafkaJavaApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(KafkaJavaApplication.class, args);
	}

}
