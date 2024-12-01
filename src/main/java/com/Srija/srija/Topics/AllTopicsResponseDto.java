package com.Srija.srija.Topics;

import java.util.List;

public class AllTopicsResponseDto {
    private List<TopicNameDto> topics;

    public AllTopicsResponseDto(List<TopicNameDto> topics) {
        this.topics = topics;
    }

    public List<TopicNameDto> getTopics() {
        return topics;
    }

    public void setTopics(List<TopicNameDto> topics) {
        this.topics = topics;
    }
}
