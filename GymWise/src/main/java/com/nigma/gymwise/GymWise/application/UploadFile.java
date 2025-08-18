package com.nigma.gymwise.GymWise.application;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class UploadFile {

    private final String FOLDER = "src//main//resources//static//images//";
    private final String IMG_DEFAULT = "default.jpg";
    private final String URL = "http://localhost:8085/images/";

    public String upload(MultipartFile multipartFile) throws IOException {

        if (multipartFile == null || multipartFile.isEmpty()) {
            return URL + IMG_DEFAULT;
        }

        String uniqueFilename = StringUtils.cleanPath(multipartFile.getOriginalFilename());

        Path destinationPath = Paths.get(FOLDER).resolve(uniqueFilename);

        Files.copy(multipartFile.getInputStream(), destinationPath);

        return URL + uniqueFilename;
    }

    public void delete(String nameFile){

        File file = new File(FOLDER+nameFile);
        file.delete();

    }

}
