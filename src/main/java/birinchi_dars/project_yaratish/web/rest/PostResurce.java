package birinchi_dars.project_yaratish.web.rest;

import birinchi_dars.project_yaratish.entity.PostData;
import birinchi_dars.project_yaratish.model.Posts;
import birinchi_dars.project_yaratish.service.PostServise;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    @PostMapping("/posts")
    public ResponseEntity create(@RequestBody Posts posts){
        Posts result=postServise.save(posts);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/posts/{id}")
    public ResponseEntity update(@PathVariable Long id,
                                 @RequestBody Posts posts){
        Posts result=postServise.update(id,posts);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/posts/params")
    public ResponseEntity getAllByparams(@RequestParam Long postId){
        List<Posts> result= (List<Posts>) postServise.findAllByQueryParam(postId);
        return ResponseEntity.ok(result);
    }
    @GetMapping("/posts/pagings")
    public ResponseEntity getAllByPaging(Pageable pageable){
        Page<PostData> result=postServise.finadAll(pageable);
        return ResponseEntity.ok(result);
    }




    @GetMapping("/posts")
    public ResponseEntity getAll(){
        Object result=postServise.findAlll();
        return ResponseEntity.ok(result);
    }


}
