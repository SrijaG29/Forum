package com.Srija.srija.Users;

import com.Srija.srija.Answers.Answers;
import com.Srija.srija.Answers.AnswersRepository;
import com.Srija.srija.Questions.Questions;
import com.Srija.srija.Questions.QuestionsRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsersService {
    private final UsersRepository usersRepository;
    private final UsersMapper usersMapper;
    private final AnswersRepository answersRepository;
    private final QuestionsRepository questionsRepository;

    public UsersService(UsersRepository usersRepository, UsersMapper usersMapper, AnswersRepository answersRepository,QuestionsRepository questionsRepository) {
        this.usersRepository = usersRepository;
        this.usersMapper = usersMapper;
        this.answersRepository = answersRepository;
        this.questionsRepository = questionsRepository;
    }

//    public UsersresponseDto createuser(
//            Users users
//    ){
//        return usersRepository.save(users);
//    }

    public UsersDto createuser(Users users) {
        return usersMapper.tofindusers(usersRepository.save(users)); // Map the saved user to DTO
    }


    public List<UsersDto> findall() {
        List<Users> usersList = (List<Users>) usersRepository.findAll(); // Get all users from the repository
        List<UsersDto> responseDtoList = new ArrayList<>();

        for (Users user : usersList) {
            UsersDto dto = usersMapper.tofindusers(user); // Map each user to UsersresponseDto
            responseDtoList.add(dto); // Add the DTO to the response list
        }

        return responseDtoList; // Return the final list of DTOs
    }


    public UsersresponseDto findbyusername(
            String username
    ){
        Users user =  usersRepository.findByUsername(username);
        UsersresponseDto usersresponseDto = new UsersresponseDto();
        usersresponseDto.setUsername(user.getUsername());
        usersresponseDto.setEmail(user.getEmail());
        List<Answers> allanswers = answersRepository.findAllByUsers(user);
        List<Integer> answerids = new ArrayList<>();
        for(Answers i : allanswers){
            answerids.add(i.getAnswerid());
        }
        usersresponseDto.setAnswerids(answerids);
        List<Questions> allquestions = questionsRepository.findAllByUsers(user);
        List<Integer> questionids = new ArrayList<>();
        for(Questions i : allquestions){
            questionids.add(i.getQuestionid());
        }
        usersresponseDto.setQuestionids(questionids);
        return usersresponseDto;

    }




}
