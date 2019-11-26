package com.example.yourgg_limhangyeol.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.File;
import java.util.List;

@Getter
@Setter
public class FileUpload {

    List<File> uploadFiles;
    List<String> failedFiles;

    public FileUpload(List<File> uploadFiles, List<String> failedFiles) {
        this.uploadFiles = uploadFiles;
        this.failedFiles = failedFiles;
    }
}
