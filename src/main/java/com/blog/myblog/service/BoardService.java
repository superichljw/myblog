package com.blog.myblog.service;


import com.blog.myblog.dto.BoardRequestDto;
import com.blog.myblog.dto.BoardResponseDto;
import com.blog.myblog.entity.Board;
import com.blog.myblog.exception.CustomException;
import com.blog.myblog.exception.ErrorCode;
import com.blog.myblog.mapper.BoardMapper;
import com.blog.myblog.paging.CommonParams;
import com.blog.myblog.paging.Pagination;
import com.blog.myblog.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;
    private final BoardMapper boardMapper;


    //게시글 작성
    @Transactional
    public Long save(final BoardRequestDto params){
        Board entity = boardRepository.save(params.toEntity());
        return entity.getBoardIdx();
    }
    //게시글 수정
    @Transactional
    public Long update(final Long boardIdx, final BoardRequestDto params) {

        Board entity = boardRepository.findById(boardIdx).orElseThrow(() -> new CustomException(ErrorCode.POSTS_NOT_FOUND));
        entity.update(params.getTitle(), params.getContents(), params.getWriter());
        return boardIdx;
    }
    //게시글 삭제
    @Transactional
    public Long delete(final Long boardIdx) {

        Board entity = boardRepository.findById(boardIdx).orElseThrow(() -> new CustomException(ErrorCode.POSTS_NOT_FOUND));
        entity.delete();
        return boardIdx;
    }
    //게시글 상세
    @Transactional
    public BoardResponseDto findById(final Long boardIdx) {

        Board entity = boardRepository.findById(boardIdx).orElseThrow(() -> new CustomException(ErrorCode.POSTS_NOT_FOUND));
        entity.increaseHits();
        return new BoardResponseDto(entity);
    }
    /**
     * 게시글 리스트 조회 - (With. pagination information)
     */
    public Map<String, Object> findAll(CommonParams params) {

        // 게시글 수 조회
        int count = boardMapper.count(params);

        // 등록된 게시글이 없는 경우, 로직 종료
        if (count < 1) {
            return Collections.emptyMap();
        }

        // 페이지네이션 정보 계산
        Pagination pagination = new Pagination(count, params);
        params.setPagination(pagination);

        // 게시글 리스트 조회
        List<BoardResponseDto> list = boardMapper.findAll(params);

        // 데이터 반환
        Map<String, Object> response = new HashMap<>();
        response.put("params", params);
        response.put("list", list);
        return response;
    }

    /**
     * 게시글 리스트 조회 - (삭제 여부 기준)
     */
    public List<BoardResponseDto> findAllByDeleteYn(final char deleteYn) {

        Sort sort = Sort.by(Sort.Direction.DESC, "boardIdx", "createdDate");
        List<Board> list = boardRepository.findAllByDeleteYn(deleteYn, sort);
        return list.stream().map(BoardResponseDto::new).collect(Collectors.toList());
    }
}
