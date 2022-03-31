package com.blog.myblog.controller;

import com.blog.myblog.exception.CustomException;
import com.blog.myblog.exception.ErrorCode;
import com.blog.myblog.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exception")
public class ExceptionController {

    @Autowired
    private BoardService boardService;

    @GetMapping("/test")
    public String test() {
        throw new RuntimeException("Holy! Exception...");
    }

    @GetMapping("/test2")
    public String test2(){
        throw new CustomException(ErrorCode.POSTS_NOT_FOUND);
    }

    @GetMapping("/test3")
    public String test3(){
        throw new CustomException(ErrorCode.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/test4")
    public String test4(){
        throw new CustomException(ErrorCode.BAD_REQUEST);
    }
    @GetMapping("/test5")
    public String test5(){
        throw new CustomException(ErrorCode.METHOD_NOT_ALLOWED);
    }
}
