package org.myungkeun.blog.payload;

import lombok.Data;

@Data
public class PostDto {
    private String title;
    private String description;
    private String content;
}
