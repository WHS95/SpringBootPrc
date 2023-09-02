package com.bootPrc.learnspringbootframwork;


import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {

    @RequestMapping("/courses")
    public List<Course> retrieveAllCourses() {
        return Arrays.asList(
                new Course(1, "Learn AWS", "in28minutes"),
                new Course(2, "Learn DevOps", "in28minutes"),
                new Course(5, "Learn Azure", "in28minutes")
        );
    }


    @Value("${property.test.name}") // depth가 존재하는 값은 .으로 구분해서 값을 매핑
    private String propertyTestName;

    @Value("${propertyTest}") // 단일 값을 매핑
    private String propertyTest;

    @Value("${noKey:default value}") // 키 값이 존재하지 않은 경우 default 값을 설정하여 매핑
    private String defaultValue;

    @Value("${propertyTestArray}") // 배열형으로 매핑
    private String[] propertyTestArray;

    @Value("#{'${propertyTestList}' .split(',')}") // ,을 기준으로 리스트형으로 매핑
    private List<String> propertyTestList;


    @RequestMapping("/valueTest")
    public void valueTest() {
        System.out.println("propertyTestName = " + propertyTestName);
        System.out.println("propertyTest = " + propertyTest);
        System.out.println("defaultValue = " + defaultValue);
        System.out.println("propertyTestArray = " + propertyTestArray);
        System.out.println("propertyTestList = " + propertyTestList);
    }


}