package com.blog.myblog.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CategoryDto {
    private Long id;
    private Long idParent;
    private String title;
    private String icon;
    private LocalDateTime createTimestamp;
    private LocalDateTime updateTimestamp;
}
