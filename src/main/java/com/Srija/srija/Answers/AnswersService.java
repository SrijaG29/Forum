package com.Srija.srija.Answers;

import com.Srija.srija.Questions.Questions;
import com.Srija.srija.Questions.QuestionsRepository;
import com.Srija.srija.Users.Users;
import com.Srija.srija.Users.UsersRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswersService {

    private final QuestionsRepository questionsRepository;
    private final AnswersRepository answersRepository;
    private final UsersRepository usersRepository;


    public AnswersService(QuestionsRepository questionsRepository,AnswersRepository answersRepository,UsersRepository usersRepository) {
        this.questionsRepository = questionsRepository;
        this.answersRepository =answersRepository;
        this.usersRepository = usersRepository;
    }


    public String createanswer(AnswersrequestDto answersrequestDto){
        Questions que = questionsRepository.findByQuestion(answersrequestDto.getQuestion());
//        System.out.println(answersrequestDto.getUserid());
        Users users = usersRepository.findByUserid(answersrequestDto.getUserid());

//        System.out.println(users.getUserid());
//        System.out.println(answersrequestDto.getQuestion());
//        System.out.println(que.getQuestionid());
//        Questions question = new Questions();
        Answers ans = new Answers();
        ans.setAnswer(answersrequestDto.getAnswer());
        ans.setQuestions(que);
        ans.setUsers(users);
        answersRepository.save(ans);
        return "Answer generated";
    }

    public List<Answers> findallanswers(
            Integer id
    ){
        Users users = usersRepository.findByUserid(id);
        return answersRepository.findAllByUsers(users);
    }


    @Transactional
    public String deleteAnswer(Integer answerId){
        answersRepository.deleteByAnswerid(answerId);
        return "Answer id deleted";

    }

}
