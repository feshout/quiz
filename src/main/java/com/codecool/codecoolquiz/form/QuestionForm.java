package com.codecool.codecoolquiz.form;

public class QuestionForm {

    private String title;
    private String description;
    private Long categoryId;
    private String answer1;
    private boolean isCorrect1;
    private String answer2;
    private boolean isCorrect2;
    private String answer3;
    private boolean isCorrect3;
    private String answer4;
    private boolean isCorrect4;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getAnswer1() {
        return answer1;
    }

    public void setAnswer1(String answer1) {
        this.answer1 = answer1;
    }

    public boolean isCorrect1() {
        return isCorrect1;
    }

    public void setCorrect1(boolean correct1) {
        isCorrect1 = correct1;
    }

    public String getAnswer2() {
        return answer2;
    }

    public void setAnswer2(String answer2) {
        this.answer2 = answer2;
    }

    public boolean isCorrect2() {
        return isCorrect2;
    }

    public void setCorrect2(boolean correct2) {
        isCorrect2 = correct2;
    }

    public String getAnswer3() {
        return answer3;
    }

    public void setAnswer3(String answer3) {
        this.answer3 = answer3;
    }

    public boolean isCorrect3() {
        return isCorrect3;
    }

    public void setCorrect3(boolean correct3) {
        isCorrect3 = correct3;
    }

    public String getAnswer4() {
        return answer4;
    }

    public void setAnswer4(String answer4) {
        this.answer4 = answer4;
    }

    public boolean isCorrect4() {
        return isCorrect4;
    }

    public void setCorrect4(boolean correct4) {
        isCorrect4 = correct4;
    }
}
