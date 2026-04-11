package com.gurvansh.jobtracker.controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gurvansh.jobtracker.service.SignupService;

@RestController()
@RequestMapping("/req")
public class ReqController {

  private final SignupService signupService;

  public ReqController(SignupService signupService) {
    this.signupService = signupService;
  }

  @PostMapping("signup")
  public ResponseEntity<?> signup(@RequestBody final Map<String, String> body) {
    final String email = body.get("email");
    final String password = body.get("password");
    signupService.signup(email, password);
    return ResponseEntity.ok(Map.of("message", "User created successful", "email", email));
  }

}
