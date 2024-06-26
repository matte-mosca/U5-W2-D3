package matteomoscardini.u5w2d2.repositories;

import matteomoscardini.u5w2d2.entities.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogPostDao extends JpaRepository<BlogPost, Integer> {
}
