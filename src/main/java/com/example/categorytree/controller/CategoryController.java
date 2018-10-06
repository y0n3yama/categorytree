package com.example.categorytree.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.categorytree.entity.Category;
import com.example.categorytree.entity.Item;
import com.example.categorytree.service.CategoryService;

@Controller
@RequestMapping("category")
public class CategoryController {
	
	@Autowired
	CategoryService categoryService;
	
    @GetMapping("list")
    public String list(Model model) {
    		List<Category> genres = categoryService.tree();
    		model.addAttribute("categories", genres);
    		return "categories/list";
    }
    
    @GetMapping("ranking")
    public String ranking(Model model) {
    		Map<String, List<Item>> rankMap = categoryService.ranking();
    		model.addAttribute("rankMap", rankMap);
    		return "categories/ranking";
    }
}
