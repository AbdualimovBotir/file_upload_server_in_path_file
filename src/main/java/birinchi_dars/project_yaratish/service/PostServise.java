package birinchi_dars.project_yaratish.service;

import birinchi_dars.project_yaratish.entity.PostData;
import birinchi_dars.project_yaratish.model.Posts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


@Service
public class PostServise {
    private final RestTemplate restTemplate;

    private PostDataService postDataService = null;
    @Value("${api.json placeholder}")
    private String api;
    private String uriTemplate;

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


    public List<Posts> findAllByQueryParam(Long postId){
        HttpEntity<List<Posts>> entity=new HttpEntity<>(getHeader());
        String urlTemplate= UriComponentsBuilder.fromHttpUrl(this.api+"/comments")
                .queryParam("postId","{postId}")
                .encode()
                .toUriString();
        Map<String,Object> params=new HashMap<>();
        params.put("postId",postId);

        List<Posts> result=restTemplate.exchange(
                uriTemplate,HttpMethod.GET,
                entity,
                List.class,
                params
        ).getBody();
        return result;

    }

    private HttpHeaders getHeader(){
        HttpHeaders headers=new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        return headers;
    }


    public Page<PostData> finadAll(Pageable pageable) {
        return postDataService.findAll(pageable);
    }

    private class List<T> {
    }
}
