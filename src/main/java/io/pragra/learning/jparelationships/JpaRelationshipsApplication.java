package io.pragra.learning.jparelationships;

import io.pragra.learning.jparelationships.entities.Review;
import io.pragra.learning.jparelationships.entities.Student;
import io.pragra.learning.jparelationships.entities.StudentPermit;
import io.pragra.learning.jparelationships.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class JpaRelationshipsApplication {

    @Autowired
    private StudentService service;

    public static void main(String[] args) {
        SpringApplication.run(JpaRelationshipsApplication.class, args);
    }

    @Bean
    CommandLineRunner runner() {
        return args -> {
            StudentPermit permit=
                        StudentPermit.builder()
                        .permitName("Learning from Prgra")
                        .build();
            Student student =
                    Student.builder()
                    .permit(permit)
                     .reviews(
                                Arrays.asList(
                                        Review.builder().programName("Java").reviewText("Very Happy").build(),
                                        Review.builder().programName("DevOps").reviewText("Very Happy").build(),
                                        Review.builder().programName("Automation").reviewText("Not Happy").build()
                                )
                     )
                    .name("Prakash")
                    .build();
            service.createStudent(student);

            service.createStudent(Student.builder()
                    .permit(StudentPermit.builder()
                            .permitName("NOT ALLOWED TO WORK")
                            .build())
                    .name("JOL")
                    .reviews(
                            Arrays.asList(
                                    Review.builder().programName("Java").reviewText("HAPPY").build(),
                                    Review.builder().programName("DevOps").reviewText("HAPPY").build(),
                                    Review.builder().programName("Automation").reviewText("HAPPY").build()
                            )
                    )
                    .build()
            );

            service.createStudent(Student.builder()
                    .permit(StudentPermit.builder()
                            .permitName("LEARNING PERMIT")
                            .build())
                    .name("LOVEPREET")
                    .build()
            );


        };
    }


}
