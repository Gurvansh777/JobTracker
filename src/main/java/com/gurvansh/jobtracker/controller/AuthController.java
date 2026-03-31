package com.gurvansh.jobtracker.controller;

import com.gurvansh.jobtracker.entity.User;
import com.gurvansh.jobtracker.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;

  public AuthController(UserRepository userRepository, PasswordEncoder passwordEncoder) {
    this.userRepository = userRepository;
    this.passwordEncoder = passwordEncoder;
  }

  @PostMapping("/login")
  public ResponseEntity<?> login(@RequestBody Map<String, String> body) {
    String email = body.get("email");
    String password = body.get("password");

    User user = userRepository.findByEmail(email).orElse(null);

    if (user == null || !passwordEncoder.matches(password, user.getPassword())) {
      // Return 401 Unauthorized on failed login
      return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("error", "Invalid credentials"));
    }

    // Login successful
    return ResponseEntity.ok(Map.of("message", "Login successful", "email", user.getEmail()));
  }
}