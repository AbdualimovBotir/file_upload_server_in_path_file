package birinchi_dars.project_yaratish.Repository;

import birinchi_dars.project_yaratish.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.Size;

@Repository
public interface UserRepository extends JpaRepository<Users,Long> {
    boolean existsByLogin(@Size(min = 4, max = 50) String login);

    Users findByLogin(@Size(min = 4, max = 50) String login);
}
