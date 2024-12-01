package com.Srija.srija.Topics;

import com.Srija.srija.Questions.Questions;
import com.Srija.srija.Questions.QuestionsResponseDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TopicsService {

    private final TopicsRepository topicsRepository;

    public TopicsService(TopicsRepository topicsRepository) {
        this.topicsRepository = topicsRepository;
    }

    public AllTopicsResponseDto findalltopics(){
        List<Topics> topics = topicsRepository.findAll();
        List<TopicNameDto> topicNameDtos = new ArrayList<>();
        for (Topics topic : topics) {
            topicNameDtos.add(new TopicNameDto(topic.getTopicname()));
        }
        return new AllTopicsResponseDto(topicNameDtos);
    }

    public TopicsResponseDto findbytopicname(String topicname){
        Topics topic = topicsRepository.findByTopicname(topicname);
        List<QuestionsResponseDto> questionDtos = new ArrayList<>();
        for (Questions question : topic.getQuestions()) {
            questionDtos.add(new QuestionsResponseDto(question.getQuestion()));
        }
        return new TopicsResponseDto(questionDtos);

    }
}
