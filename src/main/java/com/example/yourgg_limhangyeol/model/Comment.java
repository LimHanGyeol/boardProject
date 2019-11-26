package com.example.yourgg_limhangyeol.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import javafx.geometry.Pos;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@ToString
@Table(name = "comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_no")
    private Long commentNo;

    @ManyToOne(targetEntity = Posts.class)
    @JoinColumn(name = "posts_no")
    private Posts posts;

    @Column(name = "comment")
    private String comment;

    @Column(name = "comment_date")
    private LocalDateTime commentDate;

    @Column(name = "comment_writer")
    private String commentWriter;

    public Comment(Posts posts, String comment, String commentWriter) {
        this.posts = posts;
        this.comment = comment;
        this.commentDate = LocalDateTime.now();
        this.commentWriter = commentWriter;
    }

    public String getCommentDate() {
        if (commentDate == null) {
            return "";
        }
        return commentDate.format(DateTimeFormatter.ofPattern("yyyy.MM.dd. HH:mm"));
    }

    public void commentUpdate(String comment) {
        this.comment = comment;
    }


}
