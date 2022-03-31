package com.blog.myblog.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardIdx;

    private String title;
    private String contents;
    private int hits;
    private String writer;
    private char deleteYn;
    private LocalDateTime updatedDate;

    private LocalDateTime createdDate = LocalDateTime.now();

    @Builder
    public Board(String title, String contents, String writer,  int hits, char deleteYn){
        this.title = title;
        this.contents = contents;
        this.writer = writer;
        this.hits = hits;
        this.deleteYn = deleteYn;
    }

    public void update(String title, String contents, String writer){
        this.title = title;
        this.contents = contents;
        this.writer = writer;
        this.updatedDate = LocalDateTime.now();
    }

    /**
     * 조회 수 증가
     */
    public void increaseHits() {
        this.hits++;
    }

    /**
     * 게시글 삭제
     */
    public void delete() {
        this.deleteYn = 'Y';
    }
}
