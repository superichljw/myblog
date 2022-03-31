package com.blog.myblog.Board;

import static org.assertj.core.api.Assertions.assertThat;

import com.blog.myblog.entity.Board;
import com.blog.myblog.repository.BoardRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
public class BoardTest {

    @Autowired
    BoardRepository boardRepository;

    @Test
    void save(){
        //코드상으로는 테스트 이지만, 실제로 테이블에 데이터가 들어간다
        // 그래서, findById 메서드에서 id 값을 통해 조회할때, 실제 값으로 조회해야한다
        // 자동 id 를 생성해주기때문에 조회할때까진 문제가 없지만,
        // 삭제 테스트를 진행하고 나면, 자동생성되는 id는 숫자가 증가하는 형태이기 때문에
        // 삭제 테스트를 통과한 뒤에는 아이디 값을 바꿔서 조회해야 한다
        //1. 게시글 파라미터 생성
        Board params = Board.builder()
                .title("board title")
                .contents("board contents")
                .writer("board writer")
                .hits(1)
                .deleteYn('N')
                .build();

        //2.게시글 저장
        boardRepository.save(params);



    }

    @Test
    void findById(){
        //3. 게시글 조회
        Board entity = boardRepository.findById((long)1).get();
        assertThat(entity.getTitle()).isEqualTo("board title");
        assertThat(entity.getContents()).isEqualTo("board contents");
        assertThat(entity.getWriter()).isEqualTo("board writer");
    }

    @Test
    void findAll() {

        // 1. 전체 게시글 수 조회
        long boardsCount = boardRepository.count();

        // 2. 전체 게시글 리스트 조회
        List<Board> boards = boardRepository.findAll();
    }

    @Test
    void delete() {

        // 1. 게시글 조회
        Board entity = boardRepository.findById((long) 1).get();

        // 2. 게시글 삭제
        boardRepository.delete(entity);
    }
}
