package com.gurvansh.jobtracker.controller;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.gurvansh.jobtracker.service.AuthService;

@WebMvcTest(AuthController.class)
class AuthControllerTest {

  @MockBean
  private AuthService authService;

  @Test
  void login_shouldReturn200_whenCredentialsValid() throws Exception {
    when(authService.checkUser("test@example.com", "password")).thenReturn(true);

  }

  @Test
  void login_shouldReturn401_whenCredentialsInvalid() throws Exception {
    when(authService.checkUser(anyString(), anyString())).thenReturn(false);
  }
}
