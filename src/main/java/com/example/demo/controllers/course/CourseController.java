//Spring Initializr创建spring工程 https://start.spring.io/
package com.example.demo.controllers.course;

import com.example.demo.controllers.topic.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//http://localhost:8080/courses
@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    @RequestMapping("/topics/{courseid}/courses")
//    public String getAllCourses(){
    public List<Course> getAllCourses(@PathVariable String courseid){
//        return "All Courses";
        return courseService.getAllCourses(courseid);
    }

//    http://localhost:8080/course/spring
    @RequestMapping("/topics/{topicid}/course/{courseid}")
    public Course getCourse(@PathVariable String topicid,@PathVariable String courseid){
        return courseService.getCourse(topicid,courseid);
    }

//    http://localhost:8080/courses
    // post方法增加
//    header:  Content-Type  application/json    body:
/*{
    "id": "php",
        "name": "php Framework",
        "description": "php Framework Description"
}
用get postman验证
*/
    @RequestMapping(value = "/topics/{topicid}/courses/",method = RequestMethod.POST)
    public  void addCourse(@RequestBody Course course,@PathVariable String topicid){
        course.setTopic(new Topic(topicid,"",""));
        courseService.addCourse(course);
    }

    //    http://localhost:8080/courses/spring
    // PUT方法更新
//    header:  Content-Type  application/json    body:
/*{
    "id": "spring",
    "name": "my Spring Framework",
    "description": "Spring Framework Description"
}
用get postman验证
*/
    @RequestMapping(value = "/topics/{topicid}/courses/id",method = RequestMethod.PUT)
    public  void updateCourse(@RequestBody Course course,@PathVariable String topicid,@PathVariable String id){
        course.setTopic(new Topic(topicid,"",""));
        courseService.updateCourse(course,id);
    }

  /*
  http://localhost:8080/courses/java
  delete 方法删除
  header:  Content-Type  application/json    body:
  {
        "id": "java",
            "name": "java Framework",
            "description": "java Description"
    }*/
    @RequestMapping(value = "/topics/{topicid}/courses/{id}",method = RequestMethod.DELETE)
    public  void deleteCourse(@PathVariable String id){
        courseService.deleteCourse(id);
    }
}
