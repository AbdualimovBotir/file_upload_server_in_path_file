package birinchi_dars.project_yaratish.service;

import birinchi_dars.project_yaratish.Repository.FIleStorageRepo;
import birinchi_dars.project_yaratish.entity.FileStorege;
import birinchi_dars.project_yaratish.entity.enumeration.FileStorageStatus;
import org.hashids.Hashids;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;

@Service
public class FileStorageServise {
    private final FIleStorageRepo fIleStorageRepo;

    @Value("${upload.server.folder}")
    private String saveFolderPath;
    private final Hashids hashids;


    public FileStorageServise(FIleStorageRepo fIleStorageRepo){
        this.fIleStorageRepo=fIleStorageRepo;
        this.hashids=new Hashids(getClass().getName(),6);
    }


    public FileStorege save(MultipartFile multipartFile){
        FileStorege fileStorege=new FileStorege();
        fileStorege.setName(multipartFile.getName());
        fileStorege.setFileSize(multipartFile.getSize());
        fileStorege.setContentType(multipartFile.getContentType());
        fileStorege.setExtension(getExt(multipartFile.getOriginalFilename()));
        fileStorege.setFileStorageStatus(FileStorageStatus.DRAFT);
        fileStorege=fIleStorageRepo.save(fileStorege);

        // /ServerFolder/upload_files/2023/07/28/hashsdds.pdf

        Date now= new Date();
        //File uploadFolder=new File(this.saveFolderPath+"/upload_files"+1900+now.getYear()+"/"+now.getMonth()+1+"/"+now.getDate());
        String path=String.format("%s/upload_files/%d/%d/%d",this.saveFolderPath,
                1900+now.getYear(),1+now.getMonth(),now.getDate());
        File uploadFolder=new File(path);
        if(!uploadFolder.exists()&&uploadFolder.mkdirs())   {
            System.out.println("created folder");
        }

        fileStorege.setHashId(hashids.encode(fileStorege.getId()));
        String pathLocal=String.format("/upload_files/%d/%d/%d/%s.%s",
                1900+now.getYear(),
                1+now.getMonth(),
                now.getDate(),
                fileStorege.getHashId(),
                fileStorege.getExtension());
        fileStorege.setUploadFolder(pathLocal);
        fIleStorageRepo.save(fileStorege);

        uploadFolder=uploadFolder.getAbsoluteFile();
        File file=new File(uploadFolder,String.format("%s.%s",
                fileStorege.getHashId(),fileStorege.getExtension()));
        try {
            multipartFile.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileStorege;
    }

    public FileStorege findByHashId(String hashId){
        return fIleStorageRepo.findByHashId(hashId);
    }
    private String getExt(String fileName){
        //hisobot.doc
        String ext=null;

        if(fileName!=null&&!fileName.isEmpty()){
            int dot=fileName.lastIndexOf('.');
            if(dot>0&&dot<=fileName.length()-2){
                ext=fileName.substring(dot+1);
            }
        }
        return ext;
    }


}
