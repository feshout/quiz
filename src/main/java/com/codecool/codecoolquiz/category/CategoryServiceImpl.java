package com.codecool.codecoolquiz.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

     @Override
    public Iterable<Category> getAll() {
        return this.categoryRepository.getAllByActiveTrue();
    }

    @Override
    public Category getById(long id) {
        return this.categoryRepository.findByIdAndActiveTrue(id);
    }

    @Override
    public Category getByName(String name) {
        return this.categoryRepository.findByNameAndActiveTrue(name);
    }

    @Override
    public void save(Category category) {
        this.categoryRepository.save(category);
    }

    @Override
    public void update(Category category) {
        this.categoryRepository.save(category);
    }

    @Override
    public void archiveById(long id) {
        Category archivedCategory = this.categoryRepository.findByIdAndActiveTrue(id);
        archivedCategory.setActive(false);
        this.categoryRepository.save(archivedCategory);
    }
}
