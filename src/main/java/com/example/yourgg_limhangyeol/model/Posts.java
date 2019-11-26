package com.example.yourgg_limhangyeol.model;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@ToString
@Table(name = "posts")
public class Posts {
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
    private LocalDateTime contentDate;

    @Column(name = "hit")
    private int hit;

    @Transient
    private MultipartFile[] fileDatas;


    public Posts(String title, String image, String content, String writer, int hit) {
        this.title = title;
        this.image = image;
        this.content = content;
        this.writer = writer;
        this.contentDate = LocalDateTime.now();
        this.hit = hit;
    }

    public String getContentDate() {
        if (contentDate == null) {
            return "";
        }
        return contentDate.format(DateTimeFormatter.ofPattern("yyyy.MM.dd. HH:mm"));
    }

    public void boardUpdate(String title, String content) {
        this.title = title;
        this.content = content;
    }

    // 조회수 증가
    public int contentHitIncrease() {
        int hit = this.hit += 1;
        return hit;
    }


}
