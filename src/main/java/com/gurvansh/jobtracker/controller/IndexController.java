package com.gurvansh.jobtracker.controller;

import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

  @GetMapping("/")
  public String index() {
    return "index";
  }

  @GetMapping(path = "/hello", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Object> hello() {
      return ResponseEntity.ok(Map.of("message", "Hello World"));
  }

}