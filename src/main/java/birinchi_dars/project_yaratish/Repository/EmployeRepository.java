package birinchi_dars.project_yaratish.Repository;

import birinchi_dars.project_yaratish.entity.Employe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeRepository extends JpaRepository<Employe,Long> {
    @Query("select e from Employe e where e.name =:name and e.last_name=:last_name")
    List<Employe> findAll(@Param("name") String name,@Param("last_name") String last_name);
}
