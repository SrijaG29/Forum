package com.Srija.srija.Answers;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AnswersController {
    AnswersService answersService;

    public AnswersController(AnswersService answersService) {
        this.answersService = answersService;
    }

    @PostMapping("/createanswers")
    public String createanswer(
            @RequestBody AnswersrequestDto answersrequestDto
    ){
        return answersService.createanswer(answersrequestDto);
    }

    @GetMapping("/userscreatedanswers/{userid}")
    public List<Answers> findallanswers(
            @PathVariable("userid") Integer id
    ){
        return answersService.findallanswers(id);
    }


    @DeleteMapping("/answers/{answerId}")
    public String deleteAnswer(
            @PathVariable("answerId") Integer answerId) {
        return answersService.deleteAnswer(answerId);
    }
}
