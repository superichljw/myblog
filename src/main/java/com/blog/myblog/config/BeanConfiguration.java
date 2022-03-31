package com.blog.myblog.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {
    //테스트 할때 이 내용 없어야 통과가 된다
    // 근데, 실제 어플 실행해도 이 내용 없어도 잘된다
    // 무엇을 위해 작성한 코드인지 모르겠다, 그래서 일단 주석처리하고 진행하다가,
    // 문제생기면 그때 삭제하거나 오류 찾을 예정
//    @Bean
//    public ModelMapper modelMapper() {
//        return new ModelMapper();
//    }

}