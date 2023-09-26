package com.jms.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jms.example.sender.Sender;


@RestController
@RequestMapping("/message")
public class MessageController {
	
	@Autowired
	Sender sender;
	
	@PostMapping("/new")
	public ResponseEntity<String> createCompany(@RequestBody String message) {

		sender.send(message);

		return ResponseEntity.ok("Message sent !");
	}

}
