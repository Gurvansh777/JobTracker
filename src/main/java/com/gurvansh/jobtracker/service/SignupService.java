package com.gurvansh.jobtracker.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.gurvansh.jobtracker.entity.User;
import com.gurvansh.jobtracker.repository.UserRepository;

@Service
public class SignupService {

  private UserRepository userRepository;

  private final PasswordEncoder passwordEncoder;

  public SignupService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
    this.userRepository = userRepository;
    this.passwordEncoder = passwordEncoder;
  }

  public User signup(String email, String password) {
    if (userRepository.findByEmail(email).isPresent()) {
      throw new RuntimeException("Email already exists");
    }
    User user = new User();
    user.setEmail(email);
    user.setPassword(passwordEncoder.encode(password));
    return userRepository.save(user);
  }

}
