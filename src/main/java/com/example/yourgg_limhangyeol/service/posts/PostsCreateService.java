package com.example.yourgg_limhangyeol.service.posts;

import com.example.yourgg_limhangyeol.model.FileUpload;
import com.example.yourgg_limhangyeol.model.Posts;
import com.example.yourgg_limhangyeol.repository.PostsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

@Service
public class PostsCreateService {

    @Autowired
    private PostsRepository postsRepository;

    @Value("${file.upload.directory}")
    private String uploadFilePath;

//    public FileUpload contentCreate(String title, String content, String writer, Posts posts) {
//        File uploadFileDir = new File(uploadFilePath);
//        if (!uploadFileDir.exists()) {
//            uploadFileDir.mkdirs();
//        }
//        MultipartFile[] imageFilesData = posts.getFileDatas();
//
//        List<File> uploadFiles = new ArrayList<>();
//        List<String> failedFiles = new ArrayList<>();
//
//        for (MultipartFile fileData : imageFilesData) {
//            String fileName = fileData.getOriginalFilename();
//
//            if (fileName != null && fileName.length() > 0) {
//                try {
//                    File serverFile = new File(uploadFileDir.getAbsolutePath() + File.separator + fileName);
//
//                    BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(serverFile));
//                    outputStream.write(fileData.getBytes());
//                    outputStream.close();
//
//                    uploadFiles.add(serverFile);
//                    contentSave(title,content,writer,fileName);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                    failedFiles.add(fileName);
//                }
//            }
//        }
//        return new FileUpload(uploadFiles, failedFiles);
//    }

    public Posts contentSave(String title, String content, String writer) {
        String imagePath = "/static/contentimage/";
        //String contentImagePath = imagePath + fileName;

        Posts posts = new Posts(title,"null",content,writer,1);
        return postsRepository.save(posts);
    }

}
