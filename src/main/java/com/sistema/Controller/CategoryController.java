package com.sistema.Controller;

import com.sistema.Entities.Category;
import com.sistema.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class CategoryController {

    @Autowired
    private CategoryRepository categoriaRepository;

    @GetMapping("/categories")
    public String showCategories(Model model){
        List<Category> listCategories = categoriaRepository.findAll();
        model.addAttribute("listCategories", listCategories);
        return "categories";
    }

    @GetMapping("/categories/add")
    public String showAddCategory(Model model){
        model.addAttribute("category", Category.builder().build());
        return "addCategory";
    }


    @PostMapping("/categories/save")
    public String saveCategory(Category category){
        try {
            categoriaRepository.save(category);
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return "redirect:/categories";
    }
}
