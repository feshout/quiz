package com.codecool.codecoolquiz.question;

import com.codecool.codecoolquiz.category.Category;
import com.codecool.codecoolquiz.tag.Tag;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends CrudRepository<Question, Long> {

    List<Question> getAllByIsActiveTrue();

    List<Question> getAllByCategoryAndIsActiveTrue(Category category);
//    Uncomment after implementing tag repository
//    List<Question> getAllByTagAndIsActiveTrue(Tag tag);

    Question getByTitleAndIsActiveTrue(String title);
}
