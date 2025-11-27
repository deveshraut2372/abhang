package com.devesh.abhang.controller;

import com.devesh.abhang.config.CloudinaryService;
import com.devesh.abhang.dto.Res.FileResponce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@RestController
@RequestMapping("/api/file")
public class FileController {


    @Autowired
    private CloudinaryService cloudinaryService;

    @PostMapping("/upload")
    public ResponseEntity<FileResponce> uploadFile(@RequestParam MultipartFile file)
    {
        FileResponce fileResponce=new FileResponce();

        try
        {
            Map result=cloudinaryService.uploadFile(file);
            System.out.println("  Result ="+ result.entrySet().stream().count());

            String name= (String) result.get("secure_url");

            fileResponce.setUrl(result.get("url").toString());
            fileResponce.setFormat(result.get("format").toString());
            fileResponce.setPublicId(result.get("public_id").toString());
            fileResponce.setSecureUrl(result.get("secure_url").toString());

            System.out.println(" ");
            return new ResponseEntity<>(fileResponce, HttpStatus.OK);
        }catch (Exception e)
        {
            e.printStackTrace();
            return new ResponseEntity<>(fileResponce, HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }

}
