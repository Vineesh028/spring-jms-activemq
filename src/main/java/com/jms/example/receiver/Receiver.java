package com.jms.example.receiver;


import java.util.concurrent.CountDownLatch;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class Receiver {

  private CountDownLatch latch = new CountDownLatch(1);

  public CountDownLatch getLatch() {
    return latch;
  }

  @JmsListener(destination = "${destination.topic}")
  public void receive(String message) {
    log.info("subscriber received message='{}'", message);
    latch.countDown();
  }

}
