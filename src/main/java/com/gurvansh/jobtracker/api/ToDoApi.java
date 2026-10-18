package com.gurvansh.jobtracker.api;

import com.gurvansh.jobtracker.dto.ToDoDto;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.lang.reflect.Type;
import java.util.List;

@Component
public class ToDoApi {
  private final RestClient restClient;

  public ToDoApi(RestClient restClient) {
    this.restClient = restClient;
  }

  public List<ToDoDto> getToDoList() {
    return restClient.get().uri("/todos").retrieve().body(new ParameterizedTypeReference<List<ToDoDto>>() {
    });
  }

}
