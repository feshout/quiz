package com.codecool.codecoolquiz.quiz;

import com.codecool.codecoolquiz.user.User;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date startDate;
    @ManyToOne
//    @JoinColumn(name = "user_id")
    private User createBy;
//    @OneToMany
//    private Set<QuestionResponse> responses;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public User getCreateBy() {
        return createBy;
    }

    public void setCreateBy(User createBy) {
        this.createBy = createBy;
    }

//    public Set<QuestionResponse> getResponses() {
//        return responses;
//    }
//
//    public void setResponses(Set<QuestionResponse> responses) {
//        this.responses = responses;
//    }
}
