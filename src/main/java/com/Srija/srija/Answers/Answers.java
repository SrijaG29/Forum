package com.Srija.srija.Answers;

import com.Srija.srija.Questions.Questions;
import com.Srija.srija.Users.Users;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class Answers {

    @Id
    @GeneratedValue
    private Integer answerid;
    private String answer;
    @ManyToOne
    @JoinColumn (
            name = "userid"
    )
    @JsonBackReference
    private Users users;

    @ManyToOne
    @JoinColumn(
            name = "questionid"
    )
    @JsonBackReference
    private Questions questions;

    public Answers() {
    }

    public Questions getQuestions() {
        return questions;
    }

    public void setQuestions(Questions questions) {
        this.questions = questions;
    }

    public Integer getAnswerid() {
        return answerid;
    }

    public void setAnswerid(Integer answerid) {
        this.answerid = answerid;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }
}
