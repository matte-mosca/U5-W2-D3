package matteomoscardini.u5w2d2.repositories;

import matteomoscardini.u5w2d2.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorDao extends JpaRepository<Author, Integer> {
}
