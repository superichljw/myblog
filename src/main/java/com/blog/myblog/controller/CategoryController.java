package com.blog.myblog.controller;

import com.blog.myblog.entity.Category;
import com.blog.myblog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
//@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "/")
    public String main(Model model) {
//        model.addAttribute("template", "common/sidebar");
        return "index";
    }

    @RequestMapping(value = "/list")
    public Map<Category, List<Category>> getCategory(Model model) {
        return categoryService.getCategory();
    }

    @RequestMapping("/write")
    public String category_write(Model model){
        Map<Category, List<Category>> categoryList = categoryService.getCategory();
        System.out.println(categoryList);
        model.addAttribute("categories", categoryList);
        return "category/categoryWrite";
    }

}