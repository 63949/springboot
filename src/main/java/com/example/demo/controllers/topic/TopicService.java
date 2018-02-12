package com.example.demo.controllers.topic;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class TopicService {
    List<Topic> topics = Arrays.asList(
            new Topic("spring", "Spring Framework", "Spring Framework Description"),
            new Topic("java", "java Framework", "java Description"),
            new Topic("2js", "js Framework", "js  Description")
    );

    public List<Topic> getAllTopics() {
        return topics;
    }
}
