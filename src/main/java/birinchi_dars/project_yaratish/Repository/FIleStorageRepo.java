package birinchi_dars.project_yaratish.Repository;

import birinchi_dars.project_yaratish.entity.FileStorege;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FIleStorageRepo extends JpaRepository<FileStorege,Long> {
}
