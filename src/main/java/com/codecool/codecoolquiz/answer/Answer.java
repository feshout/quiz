package com.codecool.codecoolquiz.answer;

import com.codecool.codecoolquiz.question.Question;

import javax.persistence.*;

@Entity
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;
}
