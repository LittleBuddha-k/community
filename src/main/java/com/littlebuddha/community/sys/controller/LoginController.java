package com.littlebuddha.community.sys.controller;

import com.littlebuddha.community.launch.service.QuestionService;
import com.littlebuddha.community.sys.entity.User;
import com.littlebuddha.community.sys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;
    @Autowired
    private QuestionService questionService;

    @GetMapping("/login")
    public String loginForm(){
        return "sys/login";
    }

    @PostMapping("/login")
    public String loginHandler(@RequestParam(value = "account",required = true) String account,
                               @RequestParam(value = "password",required = true) String password,
                               @RequestParam(value = "isRemember",required = false) String isRemember,
                               HttpSession session, HttpServletResponse response){
        User currentUser = userService.login(account, password);
        if(currentUser == null || currentUser.getId() == null){
            return "redirect:/register";
        }

        session.setAttribute("currentUser",currentUser);
        return "redirect:/index";
    }

    @GetMapping(value = {"/register"})
    public String registerForm(){
        return "sys/register";
    }

    @PostMapping(value = {"/register"})
    public String registerHandler(@RequestParam(value = "account",required = true) String account,
                         @RequestParam(value = "password",required = true) String password,
                         Model model){
        userService.register(account,password);
        return "sys/login";
    }

    @GetMapping("/logOut")
    public String logOut(HttpSession session){
        session.removeAttribute("currentUser");
        return "redirect:/index";
    }
}
