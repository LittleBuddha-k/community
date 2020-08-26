package com.littlebuddha.community.launch.util;

import com.littlebuddha.community.sys.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.UUID;

public class FileUpload {

    @Autowired
    private UserMapper userMapper;

    final static String UPLOAD_DIR = "upload";

    public static void upload(MultipartFile file, HttpSession session) {
        String originalFilename = "";
        if (file.getSize() > 0) {
            originalFilename = file.getOriginalFilename();
        }

        //创建文件夹
        try {
            File path = new File(ResourceUtils.getURL("classpath:").getPath());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
