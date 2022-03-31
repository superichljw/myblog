package com.blog.myblog.dto;

import com.blog.myblog.entity.Board;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BoardRequestDto {

    private String title; // 제목
    private String contents; // 내용
    private String writer; // 작성자
    private char deleteYn; // 삭제 여부

    public Board toEntity() {
        return Board.builder()
                .title(title)
                .contents(contents)
                .writer(writer)
                .hits(0)
                .deleteYn(deleteYn)
                .build();

    }

}
