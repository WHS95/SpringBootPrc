package com.data.JPA_H2learnSpringframwork.course.jpa;


import com.data.JPA_H2learnSpringframwork.course.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class CourseJpaRepository {

    //영속성 컨텍스트
    //단순 @Autowired보다 명확하다.
    @PersistenceContext
    private EntityManager entityManager;


    public void insert(Course course) {
        entityManager.merge(course);
    }

    public Course findById(long id) {
        return entityManager.find(Course.class, id);
    }

    public void deleteById(long id) {
        Course course = entityManager.find(Course.class, id);
        entityManager.remove(course);
    }
}
