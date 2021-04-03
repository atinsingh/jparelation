package io.pragra.learning.jparelationships.controller;

import io.pragra.learning.jparelationships.entities.Student;
import io.pragra.learning.jparelationships.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {
    private StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping(value = "/student", produces =  MediaType.APPLICATION_JSON_VALUE)
    public List<Student> getAllStudent() {
        return service.findAll();
    }

    @GetMapping("/student/{studentId}")
    public Student getStudentById(@PathVariable("studentId") int id) {
        return service.findById(id);
    }

    @PostMapping("/student")
    public Student createNewStudent(@RequestBody Student student) {
        return service.createStudent(student);
    }


}
