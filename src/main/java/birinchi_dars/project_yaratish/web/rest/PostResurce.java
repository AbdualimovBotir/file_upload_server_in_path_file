package birinchi_dars.project_yaratish.web.rest;

import birinchi_dars.project_yaratish.entity.Employe;
import birinchi_dars.project_yaratish.model.Posts;
import birinchi_dars.project_yaratish.service.PostServise;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PostResurce {
    private final PostServise postServise;
    public PostResurce(PostServise postServise){
        this.postServise=postServise;
    }
    @GetMapping("/posts")
    public ResponseEntity getAll(){
        List<Posts> result=postServise.findAll();
        return ResponseEntity.ok(result);
    }

    @PostMapping("/postss")
    public ResponseEntity postAll(@RequestBody Posts posts) {
        Posts result=postServise.save(posts);
        return ResponseEntity.ok(result);
    }
}
