package birinchi_dars.project_yaratish.Repository;

import birinchi_dars.project_yaratish.model.Posts;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PostrRepo extends JpaRepository<Posts ,Long> {
    @Override
    Optional<Posts> findById(Long aLong);
}
