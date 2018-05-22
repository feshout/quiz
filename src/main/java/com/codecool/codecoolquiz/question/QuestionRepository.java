package com.codecool.codecoolquiz.question;

import com.codecool.codecoolquiz.category.Category;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface QuestionRepository extends CrudRepository<Question, Long> {

    @Query(
            "SELECT question FROM Question question WHERE category_id IN :categories"
    )
    public List<Question> findByCategory(@Param("categories")List<Long> categories);
}
