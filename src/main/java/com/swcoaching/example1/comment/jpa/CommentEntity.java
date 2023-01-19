package com.swcoaching.example1.comment.jpa;

import com.swcoaching.example1.board.jpa.PostEntity;
import com.swcoaching.example1.common.jpa.BaseEnitity;
import com.swcoaching.example1.user.jpa.UserEntity;
import jakarta.persistence.*;

@Table(name = "comment")
@Entity
public class CommentEntity extends BaseEnitity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "text")
    private String content;

    @ManyToOne
    @JoinColumn(name = "postId")
    private PostEntity post;

    @ManyToOne
    @JoinColumn(name = "userId")
    private UserEntity user;

    public Long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}
