package com.blog.myblog.controller;

import com.blog.myblog.dto.BoardRequestDto;
import com.blog.myblog.dto.BoardResponseDto;
import com.blog.myblog.paging.CommonParams;
import com.blog.myblog.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class BoardApiController {

    private final BoardService boardService;

    /**
     * 게시글 생성
     */
    @PostMapping("/boards")
    public Long save(@RequestBody final BoardRequestDto params) {
        return boardService.save(params);
    }

    /**
     * 게시글 수정
     */
    @PatchMapping("/boards/{boardIdx}")
    public Long update(@PathVariable final Long boardIdx, @RequestBody final BoardRequestDto params) {
        return boardService.update(boardIdx, params);
    }

    /**
     * 게시글 삭제
     */
    @DeleteMapping("/boards/{boardIdx}")
    public Long delete(@PathVariable final Long boardIdx) {
        return boardService.delete(boardIdx);
    }

    /**
     * 게시글 리스트 조회
     */
    @GetMapping("/boards")
    public Map<String, Object> findAll(final CommonParams params) {
        return boardService.findAll(params);
    }

    /**
     * 게시글 상세정보 조회
     */
    @GetMapping("/boards/{boardIdx}")
    public BoardResponseDto findById(@PathVariable final Long boardIdx) {
        return boardService.findById(boardIdx);
    }
}
