package com.example.demo.controllers.topic;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

//http://localhost:8080/topics
@RestController
public class TopicController {
    @RequestMapping("/topics")
//    public String getAllTopics(){
    public List<Topic> getAllTopics(){
//        return "All Topics";
        return Arrays.asList(
                new Topic("spring","Spring Framework","Spring Framework Description"),
                new Topic("java","java Framework","java Description"),
                new Topic("js","js Framework","js  Description")
        );
    }
}
