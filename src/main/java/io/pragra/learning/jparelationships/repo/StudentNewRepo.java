package io.pragra.learning.jparelationships.repo;

import io.pragra.learning.jparelationships.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class StudentNewRepo {
    @Autowired
    private EntityManager manager;

    public void createStudent(Student student) {
        manager.persist(student);
    }

    public Student findById(Integer id) {
        return manager.find(Student.class, id);
    }
}
