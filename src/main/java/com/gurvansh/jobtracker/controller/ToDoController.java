package com.gurvansh.jobtracker.controller;

import com.gurvansh.jobtracker.dto.ToDoDto;
import com.gurvansh.jobtracker.service.ToDoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ToDoController {
  private final ToDoService toDoService;

  public ToDoController(ToDoService toDoService) {
    this.toDoService = toDoService;
  }

  @GetMapping("/todos")
  public List<ToDoDto> getToDos() {
    return toDoService.getToDoList();
  }
}
