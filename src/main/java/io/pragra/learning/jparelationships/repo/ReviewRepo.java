package io.pragra.learning.jparelationships.repo;

import io.pragra.learning.jparelationships.entities.Review;
import io.pragra.learning.jparelationships.entities.ReviewPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepo extends JpaRepository<Review, ReviewPK> {
}
