package com.Srija.srija.Topics;

import com.Srija.srija.Questions.Questions;
import com.Srija.srija.Questions.QuestionsResponseDto;

import java.util.List;

public class TopicsResponseDto {

    private List<QuestionsResponseDto> questions;

    public TopicsResponseDto(List<QuestionsResponseDto> questions) {
        this.questions = questions;
    }

    public List<QuestionsResponseDto> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuestionsResponseDto> questions) {
        this.questions = questions;
    }
}
