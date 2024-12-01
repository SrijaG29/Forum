package com.Srija.srija.Answers;

import com.Srija.srija.Users.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnswersRepository extends JpaRepository<Answers,Integer> {
    List<Answers> findAllByUsers(Users users);
    void deleteByAnswerid(Integer answerid);
}
