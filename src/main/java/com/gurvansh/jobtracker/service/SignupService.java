package com.gurvansh.jobtracker.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.gurvansh.jobtracker.entity.Role;
import com.gurvansh.jobtracker.entity.User;
import com.gurvansh.jobtracker.enums.RoleName;
import com.gurvansh.jobtracker.repository.RoleRepository;
import com.gurvansh.jobtracker.repository.UserRepository;

@Service
public class SignupService {

  private UserRepository userRepository;

  private RoleRepository roleRepository;

  private final PasswordEncoder passwordEncoder;

  public SignupService(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
    this.userRepository = userRepository;
    this.roleRepository = roleRepository;
    this.passwordEncoder = passwordEncoder;
  }

  public User signup(String email, String password) {
    if (userRepository.findByEmail(email).isPresent()) {
      throw new RuntimeException("Email already exists");
    }
    User user = new User();
    user.setEmail(email);
    user.setPassword(passwordEncoder.encode(password));

    Role roleUser = roleRepository.findByName(RoleName.ROLE_USER.toString())
        .orElseThrow(() -> new RuntimeException("Role not found"));
    user.getRoles().add(roleUser);

    return userRepository.save(user);
  }

}
