package com.Srija.srija.Users;

import java.util.List;

public class UsersresponseDto {
    String username;
    String email;
    List<Integer> questionids;
    List<Integer> answerids;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Integer> getQuestionids() {
        return questionids;
    }

    public void setQuestionids(List<Integer> questionids) {
        this.questionids = questionids;
    }

    public List<Integer> getAnswerids() {
        return answerids;
    }

    public void setAnswerids(List<Integer> answerids) {
        this.answerids = answerids;
    }
}
