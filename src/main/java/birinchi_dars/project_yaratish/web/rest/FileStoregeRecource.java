package birinchi_dars.project_yaratish.web.rest;

import birinchi_dars.project_yaratish.entity.FileStorege;
import birinchi_dars.project_yaratish.service.FileStorageServise;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api")
public class FileStoregeRecource {
    private final FileStorageServise fileStorageServise;


    public FileStoregeRecource(FileStorageServise fileStorageServise){
        this.fileStorageServise=fileStorageServise;
    }

    @PostMapping("/upload")
    public ResponseEntity upload(@RequestParam("file") MultipartFile multipartFile){
        FileStorege fileStorege=fileStorageServise.save(multipartFile);
        return ResponseEntity.ok(fileStorege);
    }

}
