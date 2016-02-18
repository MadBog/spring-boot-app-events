package ro.bogdanlyex.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.bogdanlyex.entities.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
