package com.codecool.codecoolquiz.question;

import com.codecool.codecoolquiz.category.Category;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends CrudRepository<Question, Long> {

    @Query(
            "SELECT question FROM Question question WHERE category_id IN :categories"
    )
    List<Question> findByCategory(@Param("categories")List<Long> categories);


    List<Question> getAllByIsActiveTrue();

    List<Question> getAllByCategoryAndIsActiveTrue(Category category);
//    Uncomment after implementing tag repository
//    List<Question> getAllByTagAndIsActiveTrue(Tag tag);

    Question getByTitleAndIsActiveTrue(String title);
}
