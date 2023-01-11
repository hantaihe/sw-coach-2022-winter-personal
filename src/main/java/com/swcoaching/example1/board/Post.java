package com.swcoaching.example1.board;

import com.swcoaching.example1.board.jpa.PostEntity;
import lombok.Getter;
import lombok.ToString;

/**
 * 게시물
 */
@ToString
@Getter
public class Post {
  private final Long id;

  private final String title;

  private final String content;

  public Post(Long id, String title, String content) {
    this.id = id;
    this.title = title;
    this.content = content;
  }

  public static Post of(PostEntity postEntity) {
    return new Post(postEntity.getId(), postEntity.getTitle(), postEntity.getContent());
  }
}
