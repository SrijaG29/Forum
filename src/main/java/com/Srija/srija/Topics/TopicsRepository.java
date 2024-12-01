package com.Srija.srija.Topics;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TopicsRepository extends JpaRepository<Topics,Integer> {
    List<Topics> findAll();
    Topics findByTopicname(String topicName);
}
