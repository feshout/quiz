package com.codecool.codecoolquiz.category;

import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {

    Iterable<Category> getAllByActiveTrue();

    Category findByIdAndActiveTrue(long id);

    Category findByNameAndActiveTrue(String name);
}
