package com.codecool.codecoolquiz.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

     @Override
    public Iterable<Category> getAll() {
        return this.categoryRepository.getAllByIsActiveTrue();
    }

    @Override
    public Category getById(long id) {
        return this.categoryRepository.findByIdAndIsActiveTrue(id);
    }

    @Override
    public Category getByName(String name) {
        return this.categoryRepository.findByNameAndIsActiveTrue(name);
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
        Category archivedCategory = this.categoryRepository.findByIdAndIsActiveTrue(id);
        archivedCategory.setActive(false);
        this.categoryRepository.save(archivedCategory);
    }
}
