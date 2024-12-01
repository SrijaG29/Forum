package com.Srija.srija.Questions;

import java.util.List;

public class AllQuestionsResponseDto {
    List<QuestionsResponseDto> questions;

    public AllQuestionsResponseDto(List<QuestionsResponseDto> questions) {
        this.questions = questions;
    }

    public List<QuestionsResponseDto> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuestionsResponseDto> questions) {
        this.questions = questions;
    }
}
