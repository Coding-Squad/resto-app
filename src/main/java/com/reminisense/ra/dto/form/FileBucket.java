package com.reminisense.ra.dto.form;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by Nigs on 2016-06-21.
 */
public class FileBucket {

    MultipartFile file;

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
