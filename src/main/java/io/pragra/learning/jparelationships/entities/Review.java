package io.pragra.learning.jparelationships.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@XmlRootElement
public class Review {

    @EmbeddedId
    private ReviewPK reviewPK;


    private String programName;

    private String reviewText;

    @ManyToOne
    private Student student;
}
