package com.gurvansh.jobtracker.service;

import com.gurvansh.jobtracker.api.ToDoApi;
import com.gurvansh.jobtracker.dto.ToDoDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoService {
  private final ToDoApi toDoApi;

  public ToDoService(ToDoApi toDoApi) {
    this.toDoApi = toDoApi;
  }

  public List<ToDoDto> getToDoList() {
    return toDoApi.getToDoList();
  }
}
