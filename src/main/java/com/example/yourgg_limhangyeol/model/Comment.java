package com.example.yourgg_limhangyeol.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;

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
    @JsonProperty
    private Long commentNo;

    @Column(name = "posts_no")
    @JsonProperty
    private int postsNo;

    @Column(name = "comment")
    @JsonProperty
    private String comment;

    @Column(name = "comment_date")
    @JsonProperty
    private String commentDate;

    @Column(name = "comment_writer")
    @JsonProperty
    private String commentWriter;

    public Comment(int postsNo, String comment, String commentDate, String commentWriter) {
        this.postsNo = postsNo;
        this.comment = comment;
        this.commentDate = commentDate;
        this.commentWriter = commentWriter;
    }

    public void commentUpdate(String comment) {
        this.comment = comment;
    }
}
