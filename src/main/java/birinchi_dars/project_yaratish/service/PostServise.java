package birinchi_dars.project_yaratish.service;

import birinchi_dars.project_yaratish.Repository.PostrRepo;
import birinchi_dars.project_yaratish.model.Posts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@Service
public class PostServise {
    private final RestTemplate restTemplate;
    private  PostrRepo postrRepo;
    @Value("${api.json placeholder}")
    private String api;

    public PostServise(RestTemplate restTemplate){
        this.restTemplate=restTemplate;
    }

    public List<Posts> findAll(){
        HttpHeaders headers=new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<List<Posts>> entity=new HttpEntity<>(headers);
        List<Posts>result=restTemplate.exchange(this.api+"/posts", HttpMethod.GET,entity,List.class).getBody();
        return result;
    }

//        public Posts save(Posts posts) {
//            Posts post=new Posts();
//
//        }
}
