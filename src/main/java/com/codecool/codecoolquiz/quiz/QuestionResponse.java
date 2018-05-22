package com.codecool.codecoolquiz.quiz;

import com.codecool.codecoolquiz.answer.Answer;
import com.codecool.codecoolquiz.question.Question;

import javax.persistence.*;
import java.util.Set;

@Entity
public class QuestionResponse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
//    @JoinColumn(name = "quiz_id")
    private Quiz quiz;
    @ManyToOne
//    @JoinColumn(name = "question_id")
    private Question question;
//    @OneToMany
//    private Set<Answer> answers;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

//    public Set<Answer> getAnswers() {
//        return answers;
//    }
//
//    public void setAnswers(Set<Answer> answers) {
//        this.answers = answers;
//    }
}
