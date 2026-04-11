package com.gurvansh.jobtracker.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.gurvansh.jobtracker.entity.User;
import com.gurvansh.jobtracker.repository.UserRepository;

@Service
public class AuthService {

  private final UserRepository userRepository;

  private final PasswordEncoder passwordEncoder;

  public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
    this.userRepository = userRepository;
    this.passwordEncoder = passwordEncoder;
  }

  public boolean checkUser(final String email, final String password) {
    User user = userRepository.findByEmail(email).orElse(null);
    if (user == null || !passwordEncoder.matches(password, user.getPassword())) {
      return false;
    }
    return true;
  }

}
