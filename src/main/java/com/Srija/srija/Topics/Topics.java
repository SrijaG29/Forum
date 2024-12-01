package com.Srija.srija.Topics;

import com.Srija.srija.Questions.Questions;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Topics {
    @Id
    @GeneratedValue
    private Integer topicid;
    private String topicname;
    private Integer topiccount;

    public Integer getTopiccount() {
        return topiccount;
    }

    public void setTopiccount(Integer topiccount) {
        this.topiccount = topiccount;
    }

    @ManyToMany(
            mappedBy = "topics"
    )
    @JsonManagedReference
    private List<Questions> questions;

    public Topics() {
    }

    public Integer getTopicid() {
        return topicid;
    }

    public void setTopicid(Integer topicid) {
        this.topicid = topicid;
    }

    public String getTopicname() {
        return topicname;
    }

    public void setTopicname(String topicname) {
        this.topicname = topicname;
    }

    public List<Questions> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Questions> questions) {
        this.questions = questions;
    }
}

