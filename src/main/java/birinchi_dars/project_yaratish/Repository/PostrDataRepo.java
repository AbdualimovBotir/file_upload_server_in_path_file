package birinchi_dars.project_yaratish.Repository;

import birinchi_dars.project_yaratish.entity.PostData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping
public interface PostrDataRepo extends JpaRepository<PostData,Long> {

}
