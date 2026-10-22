package com.gurvansh.jobtracker.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Slf4j
@Component
public class BookAspect {
  @Before("execution(* com.gurvansh.jobtracker.controller.BookController.*(..))")
  public void logBefore() {
    log.info("In Before");
  }
}
