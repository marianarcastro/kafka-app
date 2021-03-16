package com.mailService.javakafka.kafkajava.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.mailService.javakafka.kafkajava.service.MailService;
	 
@Component
public class MailConsumer {
	
	@Autowired
	private MailService mailService;
	
	
	@KafkaListener(topics = "${mail.topic}", groupId = "${spring.kafka.consumer.group-id}")
	public void consumer(String mail) throws Exception {
		System.out.println(mail);
		mailService.sendEmail(mail);
	}
}