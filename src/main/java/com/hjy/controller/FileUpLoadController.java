package com.hjy.controller;

import com.hjy.pojo.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * ClassName: FileUpLoadController
 * Package: com.hjy.controller
 * Description:
 *
 * @Author 黄嘉宇
 * @Create 2024/5/10 21:00
 * @Version 1.0
 */
@RestController
public class FileUpLoadController {

    @PostMapping("/upload")
    public Result<String> upload(MultipartFile file){

    }
}
