package io.pragra.learning.jparelationships.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@ToString
public class StudentPermit {
    @Id
    @GeneratedValue
    private Integer id;

    private String permitName;

}
