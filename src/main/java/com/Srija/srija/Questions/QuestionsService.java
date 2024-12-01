package com.Srija.srija.Questions;

import com.Srija.srija.Answers.Answers;
import com.Srija.srija.Topics.AllTopicsResponseDto;
import com.Srija.srija.Topics.TopicNameDto;
import com.Srija.srija.Topics.Topics;
import com.Srija.srija.Topics.TopicsRepository;
import com.Srija.srija.Users.Users;
import com.Srija.srija.Users.UsersRepository;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class QuestionsService {

    private final QuestionsRepository questionsRepository;
    private final TopicsRepository topicsRepository;
    private final UsersRepository usersRepository;

    public QuestionsService(QuestionsRepository questionsRepository, TopicsRepository topicsRepository,UsersRepository usersRepository) {
        this.questionsRepository = questionsRepository;
        this.topicsRepository = topicsRepository;
        this.usersRepository = usersRepository;
    }

//    public String createquestion(QuestionsrequestDto questions) {
//        String name = questions.getTopic();
//        String[] topiclist = name.split(",");
//        List<Topics> topicinstance = new ArrayList<>();
//        System.out.println(Arrays.toString(topiclist));
//        for (String topics : topiclist) {
//            Topics ex = topicsRepository.findByTopicname(topics);
//            if (ex == null ) {
//                Topics topic = new Topics();
//                topic.setTopicname(topics);
//                if(topic.getTopiccount() == null){
//                    topic.setTopiccount(1);
//                }
//                else{
//                    topic.setTopiccount(topic.getTopiccount()+1);
//                }
//
//                topicinstance.add(topic);
//            }
//            else{
//                Topics topic = new Topics();
//                if(topic.getTopiccount() == null){
//                    topic.setTopiccount(1);
//                }
//                else{
//                    topic.setTopiccount(topic.getTopiccount()+1);
//                }
//                topicinstance.add(topicsRepository.findByTopicname(topics));
//            }
//        }
//        Questions ques = new Questions();
//        ques.setQuestion(questions.getQuestions());
//        ques.setTopics(topicinstance);
//        System.out.println(ques.getTopics());
//        questionsRepository.save(ques);
//        return "Question created";
//    }

    public String createquestion(QuestionsrequestDto questions) {
        String name = questions.getTopic();
        String[] topicList = name.split(",");
        List<Topics> topicInstances = new ArrayList<>();

        System.out.println(Arrays.toString(topicList));

        for (String topicName : topicList) {
            Topics topic = topicsRepository.findByTopicname(topicName);

            if (topic == null) {
                // Create a new topic if it doesn't exist
                topic = new Topics();
                topic.setTopicname(topicName);
                topic.setTopiccount(1); // Initialize topic count to 1
            } else {
                // Update the topic count if it already exists
                topic.setTopiccount(topic.getTopiccount() + 1);
            }

            // Save the topic to ensure the updated count is persisted
            topicsRepository.save(topic);

            // Add the topic instance to the list
            topicInstances.add(topic);
        }

        // Create and save the question
        Questions ques = new Questions();
        ques.setQuestion(questions.getQuestions());
        ques.setTopics(topicInstances);

        Users users = usersRepository.findByUserid(questions.getUserid());
        ques.setUsers(users);
        questionsRepository.save(ques);
        System.out.println(ques.getTopics());
        return "Question created";
    }

    public List<Questions> findallanswers(
            Integer id
    ){
        Users users = usersRepository.findByUserid(id);
        return questionsRepository.findAllByUsers(users);
    }

    public AllQuestionsResponseDto findallquestions(){
        List<Questions> questions = questionsRepository.findAll();
        List<QuestionsResponseDto> questionsResponseDtos = new ArrayList<>();
        for (Questions questions1 : questions) {
            questionsResponseDtos.add(new QuestionsResponseDto(questions1.getQuestion()));
        }
        return new AllQuestionsResponseDto(questionsResponseDtos);
    }

    public Questions findbyquestion(String question){
        return questionsRepository.findByQuestion(question);
    }

    public String deleteAnswer(Integer questionId, Integer answerId){
        Optional<Questions> questionOptional = questionsRepository.findById(questionId);

        return "Answer is deleted";
    }
}
