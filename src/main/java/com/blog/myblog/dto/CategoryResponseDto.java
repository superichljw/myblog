package com.blog.myblog.dto;

import com.blog.myblog.entity.Category;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CategoryResponseDto {
    private Long id;
    private Long idParent;
    private String title;
    private String icon;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime createTimestamp;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime updateTimestamp;

    public CategoryResponseDto(Category entity){
        this.id = entity.getId();
        this.idParent = entity.getIdParent();
        this.title = entity.getTitle();
        this.icon = entity.getIcon();
        this.createTimestamp = entity.getCreateTimestamp();
        this.updateTimestamp = entity.getUpdateTimestamp();
    }
}
