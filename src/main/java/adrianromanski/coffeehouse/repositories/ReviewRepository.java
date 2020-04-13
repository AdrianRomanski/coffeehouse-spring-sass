package adrianromanski.coffeehouse.repositories;

import adrianromanski.coffeehouse.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {

}
