package com.codecool.codecoolquiz.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping(path = "")
    public ModelAndView index(ModelAndView modelAndView) {
        modelAndView.setViewName("category/categoriesbody :: content");

        modelAndView.addObject("categories", this.categoryService.getAll());
        modelAndView.addObject("title", "categories");

        return modelAndView;
    }

    @GetMapping(path = "/{id}")
    public ModelAndView showById(@PathVariable Long id, ModelAndView modelAndView) {
        modelAndView.setViewName("category/categorybody :: content");
        modelAndView.addObject(this.categoryService.getById(id));
        modelAndView.addObject("title", "category");

        return modelAndView;
    }

//    unused method causing AmbiguousHandler exception
//    @GetMapping(path = "/{name}")
//    public String showByName(@PathVariable String name, Model model) {
//        model.addAttribute(this.categoryService.getByName(name));
//        return "category/category";
//    }

    @GetMapping(path = "/new")
    public ModelAndView getCreateForm(ModelAndView modelAndView){
        modelAndView.setViewName("category/categoryformbody :: content");
        modelAndView.addObject("category", new Category());
        modelAndView.addObject("title", "new");
        modelAndView.addObject("button", "new");

        return modelAndView;
    }

    @PostMapping(path = "/new")
    public String create(@ModelAttribute Category category) {
        this.categoryService.save(category);
       category = this.categoryService.getByName(category.getName());

        return "redirect:/categories/" + category.getId();
    }

    @GetMapping(path = "/edit/{id}")
    public ModelAndView getCreateForm(@PathVariable Long id, ModelAndView modelAndView){
        Category editCategory = this.categoryService.getById(id);

        modelAndView.setViewName("category/categoryformbody :: content");
        modelAndView.addObject("category", editCategory);
        modelAndView.addObject("title", "edit");
        modelAndView.addObject("button", "edit");

        return modelAndView;
    }

    @PutMapping(path = "/edit/{id}")
    public String update(@ModelAttribute Category category) {
        this.categoryService.update(category);
        return "redirect:/categories/" + category.getId();
    }

    @DeleteMapping(path = "/{id}")
    public String delete(@PathVariable Long id) {
        this.categoryService.archiveById(id);
        return "redirect:/categories";
    }
}
