package com.Srija.srija.Users;

import com.Srija.srija.Answers.Answers;
import com.Srija.srija.Questions.Questions;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
public class Users {
    @Id
    @GeneratedValue
    private Integer userid;
    @Column(unique = true, nullable = false)
    private String username;
    @Column(unique = true, nullable = false)
    private String email;
    @Size(min = 8, message = "Password must be at least 8 characters long")
    @Column(nullable = false)
    private String password;

    @OneToMany(
            mappedBy = "users",
            cascade = CascadeType.ALL
    )
    @JsonManagedReference
    private List<Answers> answer;

    @OneToMany(
            mappedBy = "users",
            cascade = CascadeType.ALL
    )
    @JsonManagedReference
    private List<Questions> questions;

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

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

    public @Size(min = 8, message = "Password must be at least 8 characters long") String getPassword() {
        return password;
    }

    public void setPassword(@Size(min = 8, message = "Password must be at least 8 characters long") String password) {
        this.password = password;
    }

    public List<Answers> getAnswer() {
        return answer;
    }

    public void setAnswer(List<Answers> answer) {
        this.answer = answer;
    }

    public Users() {
    }
}
