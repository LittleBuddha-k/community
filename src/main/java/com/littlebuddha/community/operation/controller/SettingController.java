package com.littlebuddha.community.operation.controller;

import com.littlebuddha.community.sys.entity.User;
import com.littlebuddha.community.sys.mapper.UserMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/operation")
public class SettingController {

    @Autowired
    private UserMapper userMapper;

    @ModelAttribute
    public User get(@RequestParam(name = "id",required = false)String id){
        User user = null;
        if(!StringUtils.isBlank(id)){
            user = userMapper.get(id);
            return user;
        }
        if(user == null){
            user = new User();
        }
        return user;
    }

    @GetMapping("/setting")
    public String list(User user, Model model){
        model.addAttribute("editUser",user);
        return "operation/setting";
    }


    final static String UPLOAD_DIR = "upload";

    @ResponseBody
    @PostMapping("/set/edit")
    public void list(@RequestParam(name = "file",required = false) MultipartFile file, HttpServletRequest request, HttpSession session){

    }
}
