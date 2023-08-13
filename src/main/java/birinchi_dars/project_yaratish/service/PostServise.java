package birinchi_dars.project_yaratish.service;

import birinchi_dars.project_yaratish.Repository.PostrDataRepo;
import birinchi_dars.project_yaratish.model.Posts;
import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;


@Service
public class PostServise {
    private final RestTemplate restTemplate;

    private PostDataService postDataService = null;
    @Value("${api.json placeholder}")
    private String api;

    public PostServise(RestTemplate restTemplate,PostDataService postDataService)
    {
        this.restTemplate=restTemplate;
        this.postDataService=postDataService;
    }

    public Posts save(Posts posts){
        HttpHeaders headers=new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Posts> entity=new HttpEntity<>(posts,headers);
        Posts result=restTemplate.postForObject(api+"/posts",entity,Posts.class);
        return result;
    }

    public Posts update(Long id,Posts posts){
        HttpHeaders headers=new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Posts> entity=new HttpEntity<>(posts,headers);
        Posts result=restTemplate.postForObject(api+"/posts/"+id+"/comments",entity,Posts.class);
        return result;
    }

    public Object findAlll(){
        HttpHeaders headers=new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Posts[]> entity=new HttpEntity<>(headers);
        Posts[] result=restTemplate.exchange(this.api+"/posts", HttpMethod.GET,entity,Posts[].class).getBody();
        postDataService.saveAll(result);
        return result;
    }


//    public List<Posts> findAllByQueryParam(Long postId){
//        HttpHeaders headers=new HttpHeaders();
//        headers.
//    }
}
