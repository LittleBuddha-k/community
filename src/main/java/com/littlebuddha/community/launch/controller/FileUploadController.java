package com.littlebuddha.community.launch.controller;

import com.littlebuddha.community.launch.mapper.QuestionMapper;
import com.littlebuddha.community.launch.util.MdUploadDTOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
@RequestMapping("/file")
public class FileUploadController {

    @Autowired
    private QuestionMapper questionMapper;

    /**
     * 上传头像的文件夹名称
     */
    public static final String UPLOAD_DIR = "upload";

    @ResponseBody
    @RequestMapping(value = "/upload")
    public Object fileUpload(HttpServletRequest request) {
        MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
        MultipartFile file = multipartHttpServletRequest.getFile("editormd-image-file");

        //String parent = UPLOAD_DIR;
        // 确定保存到哪个文件夹
        String parent = request
                .getServletContext()
                .getRealPath(UPLOAD_DIR);

        System.out.println("拿到了本地地址"+parent);

        File parentPath = new File(parent);
        if(!parentPath.exists()){
            parentPath.mkdir();
        }
        // 确定保存的文件名
        String originalFilename = file.getOriginalFilename();
        String suffix = "";
        int beginIndex = originalFilename.lastIndexOf(".");
        if (beginIndex != -1) {
            suffix = originalFilename.substring(beginIndex);
        }
        String child = UUID.randomUUID().toString() + suffix;

        // 确定保存到哪个文件
        File dest = new File(parentPath, child);

        try {
            file.transferTo(dest);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 执行修改头像
        String savePath = "/community/upload" + "/" + child;
        //返回MD上传图片的固定格式
        MdUploadDTOUtil mdUploadDTOUtil = new MdUploadDTOUtil();
        mdUploadDTOUtil.setSuccess(1);
        mdUploadDTOUtil.setMessage("操作成功");
        mdUploadDTOUtil.setUrl(savePath);
        return mdUploadDTOUtil;
    }
}
