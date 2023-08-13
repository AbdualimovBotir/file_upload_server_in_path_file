package birinchi_dars.project_yaratish.service;

import birinchi_dars.project_yaratish.Repository.PostrDataRepo;
import birinchi_dars.project_yaratish.entity.PostData;
import birinchi_dars.project_yaratish.model.Posts;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostDataService {
    private final PostrDataRepo postrDataRepo;

    public PostDataService(PostrDataRepo postrDataRepo) {
        this.postrDataRepo = postrDataRepo;
    }

    public PostData save(PostData postData){
        return postrDataRepo.save(postData);
    }

    public List<PostData> saveAll(Posts[] posts) {
//forech orqali

        List<PostData> postDataList1 = new ArrayList<>();
        for (Posts post : posts) {
            PostData postData = new PostData();
            postData.setPostId(post.getId());
            postData.setUserId(post.getUserId());
            postData.setTitle(post.getTitle());
            postData.setBody(postData.getBody());
            postDataList1.add(postData);
        }

        return postrDataRepo.saveAll(postDataList1);
//streemlar orqali
//        List<PostData> postDataList=posts
//                .stream()
//                .map(post -> {
//                    PostData postData=new PostData();
//                    postData.setPostId(post.getId());
//                    postData.setUserId(post.getUserId());
//                    postData.setTitle(post.getTitle());
//                    postData.setBody(postData.getBody());
//
//                    return postData;
//                }).collect(Collectors.toList());
//        return postrDataRepo.saveAll(postDataList);
//    }
    }
}
