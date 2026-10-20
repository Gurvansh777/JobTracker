package com.gurvansh.jobtracker.controller;

import com.gurvansh.jobtracker.service.AsyncTestService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api")
public class AsyncTestController {
  AsyncTestService asyncTestService;

  public AsyncTestController(AsyncTestService asyncTestService) {
    this.asyncTestService = asyncTestService;
  }

  @GetMapping("/testasync")
  public ResponseEntity<?> get() throws InterruptedException {
    asyncTestService.sendNotification();
    return ResponseEntity.ok("Done!");
  }
}
