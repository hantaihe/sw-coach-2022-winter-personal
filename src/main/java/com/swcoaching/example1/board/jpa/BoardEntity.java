package com.swcoaching.example1.board.jpa;

import com.swcoaching.example1.common.jpa.BaseEnitity;
import lombok.Getter;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Getter
@Table(name = "board")
@Entity
public class BoardEntity extends BaseEnitity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  /**
   * 게시판 제목
   */
  @Column(length = 1000)
  private String title;

  /**
   * 게시판 설명
   */
  @Column(columnDefinition = "text")
  private String introduction;

  /**
   * 게시물
   */
  @OneToMany(mappedBy = "board")
  public List<PostEntity> posts = new ArrayList<>();
}
