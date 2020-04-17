package adrianromanski.coffeehouse.repositories;

import adrianromanski.coffeehouse.domain.opinion.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
