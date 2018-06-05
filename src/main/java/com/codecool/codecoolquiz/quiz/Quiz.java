package com.codecool.codecoolquiz.quiz;

import com.codecool.codecoolquiz.user.User;
import javax.persistence.*;
import java.util.Date;

@Entity
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date startDate;
    @ManyToOne
    private User createBy;

    public Quiz(Date startDate, User createBy) {
        this.startDate = startDate;
        this.createBy = createBy;
    }

    public Quiz() {
    }

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

}