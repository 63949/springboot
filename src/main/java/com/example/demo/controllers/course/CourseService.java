package com.example.demo.controllers.course;

import com.example.demo.controllers.course.Course;
import com.example.demo.controllers.course.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getAllCourses(String topicid) {
//        return courses;
        List<Course> courses = new ArrayList<>();
        courseRepository.findByTopicId(topicid).forEach(courses::add);
        return  courses;
    }

    public Course getCourse(String topicid, String courseid){
//        return courses.stream().filter(t->t.getId().equals(id)).findFirst().get();

        return courseRepository.findOne(topicid);
    }

    public void addCourse(Course course) {
//        courses.add(course);
        courseRepository.save(course);
    }

    public void updateCourse(Course course, String id) {
      /*  for (int i = 0; i < courses.size(); i++) {
            Course t = courses.get(i);
            if (t.getId().equals(id)){
                courses.set(i,course);
                return;
            }
        }*/
        courseRepository.save(course);
    }

    public void deleteCourse(String id) {
       /* for (int i = 0; i < courses.size(); i++) {
            Course t = courses.get(i);
            if (t.getId().equals(id)){
                courses.remove(i);
                return;
            }
        }*/
       // jdk8的写法
//        courses.removeIf(t->t.getId().equals(id));
        courseRepository.delete(id);
    }
}
