package birinchi_dars.project_yaratish.web.rest;

import birinchi_dars.project_yaratish.entity.FileStorege;
import birinchi_dars.project_yaratish.service.FileStorageServise;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileUrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.yaml.snakeyaml.util.UriEncoder;

import java.net.MalformedURLException;
import java.net.URLEncoder;

@RestController
@RequestMapping("/api")
public class FileStoregeRecource {
    private final FileStorageServise fileStorageServise;

    @Value("${upload.server.folder}")
    private String saveFolderPath;

    public FileStoregeRecource(FileStorageServise fileStorageServise){
        this.fileStorageServise=fileStorageServise;
    }

    @PostMapping("/upload")
    public ResponseEntity upload(@RequestParam("file") MultipartFile multipartFile){
        FileStorege fileStorege=fileStorageServise.save(multipartFile);
        return ResponseEntity.ok(fileStorege);
    }

    @GetMapping("/file_preview/{hashId}")
    public ResponseEntity preview(@PathVariable String hashId) throws MalformedURLException {
        FileStorege fileStorege=fileStorageServise.findByHashId(hashId);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,"inline; fileName=\""+ UriEncoder.encode(fileStorege.getName()))
                .contentType(MediaType.parseMediaType(fileStorege.getContentType()))
                .contentLength(fileStorege.getFileSize())
                .body(new FileUrlResource(String.format("   %s/%s", this.saveFolderPath, fileStorege.getUploadFolder())));

    }
}
