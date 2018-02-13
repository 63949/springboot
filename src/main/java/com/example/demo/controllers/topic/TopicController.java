//Spring Initializr创建spring工程 https://start.spring.io/
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
    // post方法增加
//    header:  Content-Type  application/json    body:
/*{
    "id": "php",
        "name": "php Framework",
        "description": "php Framework Description"
}
用get postman验证
*/
    @RequestMapping(value = "/topics",method = RequestMethod.POST)
    public  void addTopic(@RequestBody Topic topic){
        topicService.addTopic(topic);
    }

    //    http://localhost:8080/topics/spring
    // PUT方法更新
//    header:  Content-Type  application/json    body:
/*{
    "id": "spring",
    "name": "my Spring Framework",
    "description": "Spring Framework Description"
}
用get postman验证
*/
    @RequestMapping(value = "/topics/{id}",method = RequestMethod.PUT)
    public  void updateTopic(@RequestBody Topic topic,@PathVariable String id){
        topicService.updateTopic(topic,id);
    }

  /*
  http://localhost:8080/topics/java
  delete 方法删除
  header:  Content-Type  application/json    body:
  {
        "id": "java",
            "name": "java Framework",
            "description": "java Description"
    }*/
    @RequestMapping(value = "/topics/{id}",method = RequestMethod.DELETE)
    public  void deleteTopic(@PathVariable String id){
        topicService.deleteTopic(id);
    }
}
