package com.example.yourgg_limhangyeol.dto;

import com.example.yourgg_limhangyeol.model.Posts;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class CommentDto {
    @JsonProperty
    private Long commentNo;
    @JsonProperty
    private Posts posts;
    @JsonProperty
    private String comment;
    @JsonProperty
    private String commentDate;
    @JsonProperty
    private String commentWriter;
}
