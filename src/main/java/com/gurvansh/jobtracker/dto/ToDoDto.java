package com.gurvansh.jobtracker.dto;

public record ToDoDto(
        int userId,
        int id,
        String title,
        boolean completed
) { }
