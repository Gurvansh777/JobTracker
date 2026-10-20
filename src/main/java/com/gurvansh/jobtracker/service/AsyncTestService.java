package com.gurvansh.jobtracker.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AsyncTestService {
  @Async
  public void sendNotification() throws InterruptedException {
    Thread.sleep(10000);
    log.info("Message Sent!-{}", Thread.currentThread().getName());
  }
}
