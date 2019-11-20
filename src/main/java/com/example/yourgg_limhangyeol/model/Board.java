package com.example.yourgg_limhangyeol.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@ToString
@Table(name = "board")
public class Board {
    // no title writer content contentDate hit image
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "no")
    private Long no;

    @Column(name = "title")
    private String title;

    @Column(name = "image")
    private String image;

    @Column(name = "content")
    private String content;

    @Column(name = "writer")
    private String writer;

    @Column(name = "content_date")
    private String contentDate;

    @Column(name = "hit")
    private int hit;


    public Board(String title, String image, String content, String writer, String contentDate, int hit) {
        this.title = title;
        this.image = image;
        this.content = content;
        this.writer = writer;
        this.contentDate = contentDate;
        this.hit = hit;
    }

    // 조회수 증가
    public int contentHitIncrease() {
        int hit = this.hit += 1;
        return hit;
    }
}
