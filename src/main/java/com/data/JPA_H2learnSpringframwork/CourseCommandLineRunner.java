package com.data.JPA_H2learnSpringframwork;

import com.data.JPA_H2learnSpringframwork.course.Course;
import com.data.JPA_H2learnSpringframwork.course.jdbc.CourseJdbcRepository;
import com.data.JPA_H2learnSpringframwork.course.jpa.CourseJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseCommandLineRunner implements CommandLineRunner{

//	@Autowired
//	private CourseJdbcRepository repository;

	@Autowired
	private CourseJpaRepository repository;

//    @Autowired
//    private CourseSpringDataJpaRepository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.insert(new Course(1, "Learn AWS Jpa!", "in28minutes"));
        repository.insert(new Course(2, "Learn AWS Jpa2!", "in28minutes"));
        repository.insert(new Course(3, "Learn AWS Jpa3!", "in28minutes"));
//        repository.save(new Course(2, "Learn Azure Jpa!", "in28minutes"));
//        repository.save(new Course(3, "Learn DevOps Jpa!", "in28minutes"));

//        repository.deleteById(1L);

        System.out.println(repository.findById(2L));
        System.out.println(repository.findById(3L));

//        System.out.println(repository.findAll());
//        System.out.println(repository.count());
//
//        System.out.println(repository.findByAuthor("in28minutes"));
//        System.out.println(repository.findByAuthor(""));
//
//        System.out.println(repository.findByName("Learn AWS Jpa!"));
//        System.out.println(repository.findByName("Learn DevOps Jpa!"));


    }

}
