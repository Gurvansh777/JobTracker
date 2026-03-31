package com.gurvansh.jobtracker.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

  private final AuthenticationManager authManager;

  public AuthService(AuthenticationManager authManager) {
    this.authManager = authManager;
  }

  public void authenticate(final String email, final String password) {
    authManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
  }

}
