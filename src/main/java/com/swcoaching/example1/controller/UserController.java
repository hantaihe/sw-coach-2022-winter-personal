package com.swcoaching.example1.controller;

import com.swcoaching.example1.user.User;
import com.swcoaching.example1.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class UserController {
  private final Logger logger = LoggerFactory.getLogger(getClass());
  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping("/user")
  public User getHello(String username) {
    User user = userService.findByUsername(username);
    logger.info("User: {}", user);
    return user;
  }
}
