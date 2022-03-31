package com.blog.myblog.dto;

import com.blog.myblog.entity.Board;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BoardResponseDto {
    private Long boardIdx;
    private String title;
    private String contents;
    private int hits;
    private String writer;
    private char deleteYn;
    private LocalDateTime updatedDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime createdDate;

    public BoardResponseDto(Board entity){
        this.boardIdx = entity.getBoardIdx();
        this.title = entity.getTitle();
        this.contents = entity.getContents();
        this.hits = entity.getHits();
        this.writer = entity.getWriter();
        this.deleteYn = entity.getDeleteYn();
        this.createdDate = entity.getCreatedDate();
        this.updatedDate = entity.getUpdatedDate();
    }
}
