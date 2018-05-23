package com.codecool.codecoolquiz.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping(path = "")
    public String index(Model model) {
        model.addAttribute(this.categoryService.getAll());
        return "category/categories";
    }

    @GetMapping(path = "/{id}")
    public String showById(@PathVariable Long id, Model model) {
        model.addAttribute(this.categoryService.getById(id));
        return "category/category";
    }

    @GetMapping(path = "/{name}")
    public String showByName(@PathVariable String name, Model model) {
        model.addAttribute(this.categoryService.getByName(name));
        return "category/category";
    }

    @GetMapping(path = "/new")
    public String getCreateForm(Model model){
        model.addAttribute("category", new Category());
        return "category/categoryform";
    }

    @PostMapping(path = "/new")
    public String create(@ModelAttribute Category category) {
        this.categoryService.save(category);
        Category newCategory = this.categoryService.getByName(category.getName());

        return "redirect:categories/" + newCategory.getId();
    }

    @GetMapping(path = "/edit/{id}")
    public String getCreateForm(@PathVariable Long id, Model model){
        model.addAttribute("category", this.categoryService.getById(id));
        return "category/categoryform";
    }

    @PutMapping(path = "/edit/{id}")
    public String update(@ModelAttribute Category category) {
        this.categoryService.update(category);
        return "redirect:categories/" + category.getId();
    }

    @DeleteMapping(path = "/{id}")
    public String delete(@PathVariable Long id) {
        this.categoryService.archiveById(id);
        return "redirect:category/categories";
    }
}
