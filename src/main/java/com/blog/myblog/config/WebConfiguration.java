package com.blog.myblog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
public class WebConfiguration implements WebMvcConfigurer {

    /*
    * webmvcconfigurer 를 통해서 작업하면
    * application.properties 에 클래스패스를 따로 등록 x
    * application.properties 에 spring.thymeleaf.prefix / suffix 등록할 경우 충돌나서 안된다
    * 
    * */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/static/**")
//                .addResourceLocations("/static/", "classpath:/static/");

        registry.addResourceHandler("/templates/**")
                .addResourceLocations("/templates/","classpath:/templates/");
    }

//    @Bean
//    public InternalResourceViewResolver getInternalResourceViewResolver(){
//        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
//        resolver.setPrefix("/templates/");
//        resolver.setSuffix(".html");
//        return resolver;
//    }
}