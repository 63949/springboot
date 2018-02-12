package com.example.demo.controllers.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

//    http://localhost:8080/topic/spring
    @RequestMapping("/topic/{id}")
    public Topic getTopic(@PathVariable String id){
        return topicService.getTopic(id);
    }

//    http://localhost:8080/topics
//    header:  Content-Type  application/json    body:
/*{
    "id": "php",
        "name": "php Framework",
        "description": "php Framework Description"
}
用get postman验证
*/
    @RequestMapping(value = "/topics",method = RequestMethod.PUT)
    public  void addTopic(@RequestBody Topic topic){
        topicService.addTopic(topic);
    }
}
