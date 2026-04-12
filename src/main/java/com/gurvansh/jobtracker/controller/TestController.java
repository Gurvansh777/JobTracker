package com.gurvansh.jobtracker.controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/info")
public class TestController {

  @GetMapping("health")
  public ResponseEntity<?> healthCheck() {
    return ResponseEntity.ok(Map.of("message", "ok"));
  }

}
