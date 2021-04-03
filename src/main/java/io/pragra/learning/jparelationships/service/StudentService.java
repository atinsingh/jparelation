package io.pragra.learning.jparelationships.service;

import io.pragra.learning.jparelationships.entities.Review;
import io.pragra.learning.jparelationships.entities.ReviewPK;
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
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@AllArgsConstructor
public class StudentService {
    private final StudentRepo repo;
    private final StudentPermitRepo studentPermitRepo;
    private final ReviewRepo reviewRepo;



    @Transactional
    public Student createStudent(Student student) {
        student.getReviews().stream().forEach(reviewRepo::save);
        return this.repo.save(student);
    }



    @Transactional
    public Student update(Student student) {
        Optional<Review> byId = reviewRepo.findById(new ReviewPK(1, 2));
        byId.get().setProgramName("ABC LEARNING");
        reviewRepo.save(byId.get());
        return repo.save(student);
    }


    public Student findById(Integer id) {
        return repo.findById(id).get();
    }
    public boolean deleteStudentById(Integer id) {
        Optional<Student> studentOptional = repo.findById(id);
        if (studentOptional.isPresent()) {
            repo.delete(studentOptional.get());
            return true;
        }
        return false;
    }

    public List<Student> findAll() {
        return repo.findAll();
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
