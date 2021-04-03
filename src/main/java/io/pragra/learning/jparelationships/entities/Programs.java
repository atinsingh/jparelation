package io.pragra.learning.jparelationships.entities;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.Duration;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Builder
public class Programs {
    @Id
    private Integer id;

    private String name;

    private Long duration;

}
