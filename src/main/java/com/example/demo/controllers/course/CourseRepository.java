package com.example.demo.controllers.course;

import com.example.demo.controllers.topic.Topic;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CourseRepository extends CrudRepository<Course,String> {
    // getAllTopics();
    // getTopic(String id);
    // updateTopic(Topic t);
    // deleteTopic(String id);
    public List<Course> findByTopicId(String topicid);// 不用实现JPA自动根据函数名实现
}
