package com.codecool.codecoolquiz.category;

public interface CategoryService {

    Iterable<Category> getAll();

    Category getById(long id);

    Category getByName(String name);

    void save(Category category);

    void update(Category category);

    void archiveById(long id);
}
