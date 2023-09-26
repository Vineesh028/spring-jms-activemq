package com.jms.example.sender;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class Sender {

  @Value("${destination.topic}")
  private String topicDestination;

  @Autowired
  private JmsTemplate jmsTemplate;

  public void send(String message) {
    log.info("sending message='{}' to destination='{}'", message,
        topicDestination);
    jmsTemplate.convertAndSend(topicDestination, message);
  }
}
