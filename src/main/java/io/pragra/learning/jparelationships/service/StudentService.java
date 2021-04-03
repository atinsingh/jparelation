package io.pragra.learning.jparelationships.service;

import io.pragra.learning.jparelationships.entities.Student;
import io.pragra.learning.jparelationships.entities.StudentPermit;
import io.pragra.learning.jparelationships.repo.ReviewRepo;
import io.pragra.learning.jparelationships.repo.StudentPermitRepo;
import io.pragra.learning.jparelationships.repo.StudentRepo;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Slf4j
@AllArgsConstructor
public class StudentService {
    private final StudentRepo repo;
    private final StudentPermitRepo studentPermitRepo;
    private final ReviewRepo reviewRepo;



    public Student createStudent(Student student) {
        student.getReviews().stream().forEach(reviewRepo::save);
        return this.repo.save(student);
    }

    public Student update(Student student) {
        return createStudent(student);
    }
    public boolean deleteStudentById(Integer id) {
        Optional<Student> studentOptional = repo.findById(id);
        if (studentOptional.isPresent()) {
            repo.delete(studentOptional.get());
            return true;
        }
        return false;
    }


    //    @Transactional
//    public void runCode() {
//        StudentPermit permit = StudentPermit.builder().permitName("JAVA FULLSTACK PERMIT").build();
//        Student student = Student.builder().name("Naveleen").funnyName("NAV").permit(permit).build();
//        System.out.println(studentPermitRepo.save(permit));
//        System.out.println(repo.save(student));
//    }
//
//
//    @Transactional
//    public void fetchData(){
//        Optional<Student> byId = repo.findById(2);
//        log.info("Student fetched from Database --> {} ", byId.get());
//        log.info("Permit fetched from Database --> {} ", byId.get().getPermit());
//    }
}
