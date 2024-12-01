package com.Srija.srija.Questions;

import com.Srija.srija.Topics.Topics;
import com.Srija.srija.Users.Users;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionsRepository extends JpaRepository<Questions,Integer> {
    Questions findByQuestion(String question);
    Questions findByQuestionid(Integer id);
    List<Questions> findAllByUsers(Users users);
}
