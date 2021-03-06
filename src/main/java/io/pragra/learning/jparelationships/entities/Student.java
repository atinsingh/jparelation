package io.pragra.learning.jparelationships.entities;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@XmlRootElement
public class Student {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(length = 255, nullable = false)
    private String name;

    @Builder.Default
    private Instant createDate = Instant.now();
    @Builder.Default
    private Instant updateDate = Instant.now();

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private StudentPermit permit;

    @Transient
    private String funnyName;

    @OneToMany(mappedBy = "student")
    @Builder.Default
    private List<Review> reviews = new ArrayList<>();

}
