package com.codecool.codecoolquiz.category;

import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {

    Iterable<Category> getAllByIsActiveTrue();

    Category findByIdAndIsActiveTrue(long id);

    Category findByNameAndIsActiveTrue(String name);
}
