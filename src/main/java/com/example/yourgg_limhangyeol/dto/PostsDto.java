package com.example.yourgg_limhangyeol.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class PostsDto {
    @JsonProperty
    private Long no;
    @JsonProperty
    private String title;
    @JsonProperty
    private String image;
    @JsonProperty
    private String content;
    @JsonProperty
    private String writer;
    @JsonProperty
    private String contentDate;
    @JsonProperty
    private int hit;


}
