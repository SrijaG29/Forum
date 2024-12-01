package com.Srija.srija.Questions;

import com.Srija.srija.Answers.Answers;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class QuestionsController {

    QuestionsService questionsService;
    public QuestionsController(QuestionsService questionsService) {
        this.questionsService = questionsService;
    }

    @PostMapping("/questions")
    public String createquestion(@RequestBody QuestionsrequestDto questions){
        return questionsService.createquestion(questions);
    }

    @GetMapping("/findallquestions")
    public AllQuestionsResponseDto findallquestions(){
        return questionsService.findallquestions();
    }

    @GetMapping("/question/{question}")
    public Questions findbyquestion(
            @PathVariable("question") String question
    ){
        return questionsService.findbyquestion(question);
    }

    @GetMapping("/userscreatedquestions/{userid}")
    public List<Questions> findallanswers(
            @PathVariable("userid") Integer id
    ){
        return questionsService.findallanswers(id);
    }







}
