package com.swcoaching.example1.user;

import com.swcoaching.example1.user.jpa.UserEntity;

public class User {
  private final Long id;
  private final String email;
  private final String username;
  private final String password;
  private final String name;
  private final String introduction;

  public User(Long id, String email, String password, String username, String name, String introduction) {
    this.id = id;
    this.email = email;
    this.password = password;
    this.username = username;
    this.name = name;
    this.introduction = introduction;
  }

  public static User of(UserEntity userEntity) {
    return new User(userEntity.getId(), userEntity.getEmail(), userEntity.getPassword(), userEntity.getUsername(),
            userEntity.getName(), userEntity.getIntroduction());
  }

  public Long getId() {
    return id;
  }

  public String getEmail() { return email; }

  public String getUsername() {
    return username;
  }

  public String getPassword() {
    return password;
  }

  public String getName() {
    return name;
  }

  public String getIntroduction() {
    return introduction;
  }
}
