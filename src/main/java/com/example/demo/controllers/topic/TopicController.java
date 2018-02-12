package com.example.demo.controllers.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

//http://localhost:8080/topics
@RestController
public class TopicController {

    @Autowired
    private TopicService topicService;

    @RequestMapping("/topics")
//    public String getAllTopics(){
    public List<Topic> getAllTopics(){
//        return "All Topics";
        return topicService.getAllTopics();
    }
}
