package com.Srija.srija.Topics;

import com.Srija.srija.Questions.Questions;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
public class TopicsController {
    private final TopicsService topicsService;

    public TopicsController(TopicsService topicsService) {
        this.topicsService = topicsService;
    }


    @GetMapping("/alltopics")
    public AllTopicsResponseDto findalltopics(){
        return topicsService.findalltopics();
    }

    @GetMapping("/allquestionsbytopic/{topicname}")
    public TopicsResponseDto findbytopicname(
            @PathVariable("topicname") String topicname
    ){
        return topicsService.findbytopicname(topicname);
    }
}
