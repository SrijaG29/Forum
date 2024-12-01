package com.Srija.srija.Questions;

import com.Srija.srija.Answers.Answers;
import com.Srija.srija.Topics.Topics;
import com.Srija.srija.Users.Users;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Questions {
    @Id
    @GeneratedValue
    private Integer questionid;
    private String question;


    @ManyToOne
    @JoinColumn (
            name = "userid"
    )
    @JsonBackReference
    private Users users;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "topicsquestions",
            joinColumns = @JoinColumn(name = "questionid",referencedColumnName = "questionid"),
            inverseJoinColumns = @JoinColumn(name = "topicid",referencedColumnName = "topicid")
    )
    @JsonBackReference
    private List<Topics> topics;

    @OneToMany(
            mappedBy = "questions",
            cascade = CascadeType.ALL
    )
    @JsonManagedReference
    private List<Answers> answers;

    public List<Answers> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answers> answers) {
        this.answers = answers;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Integer getQuestionid() {
        return questionid;
    }

    public void setQuestionid(Integer questionid) {
        this.questionid = questionid;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<Topics> getTopics() {
        return topics;
    }

    public void setTopics(List<Topics> topics) {
        this.topics = topics;
    }

    public Questions() {
    }



}
