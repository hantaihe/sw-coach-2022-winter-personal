package com.swcoaching.example1.board.jpa;

import com.swcoaching.example1.comment.jpa.CommentEntity;
import com.swcoaching.example1.common.jpa.BaseEnitity;
import com.swcoaching.example1.user.jpa.UserEntity;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * 게시물
 */
@Getter
@Table(name = "post")
@Entity
public class PostEntity extends BaseEnitity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(length = 1000)
  private String title;

  @Column(columnDefinition = "text")
  private String content;

  @ManyToOne
  @JoinColumn(name = "boardId")
  private BoardEntity board;

  @ManyToOne
  @JoinColumn(name = "userId")
  private UserEntity user;

  @OneToMany(mappedBy = "post")
  public List<CommentEntity> comments = new ArrayList<>();
}
