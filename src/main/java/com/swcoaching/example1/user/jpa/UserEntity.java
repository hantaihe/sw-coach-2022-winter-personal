package com.swcoaching.example1.user.jpa;

import com.swcoaching.example1.board.jpa.PostEntity;
import com.swcoaching.example1.comment.jpa.CommentEntity;
import com.swcoaching.example1.common.jpa.BaseEnitity;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Table(name = "user")
@Entity
public class UserEntity extends BaseEnitity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String email;
  private String username;
  private String password;
  private String name;
  private String introduction;

  @OneToMany(mappedBy = "user")
  public List<PostEntity> posts = new ArrayList<>();

  @OneToMany(mappedBy = "user")
  public List<CommentEntity> comments = new ArrayList<>();

  public Long getId() {
    return id;
  }

  public String getEmail() {
    return email;
  }

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
