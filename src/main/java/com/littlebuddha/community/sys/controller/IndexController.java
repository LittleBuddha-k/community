package com.littlebuddha.community.sys.controller;

import com.littlebuddha.community.base.page.Page;
import com.littlebuddha.community.launch.entity.Question;
import com.littlebuddha.community.launch.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexController {
    @Autowired
    private QuestionService questionService;


    @GetMapping({"/index","/"})
    public String index(Model model,
                        @RequestParam(value = "pageNo",defaultValue = "1",required = false)Integer pageNo,
                        @RequestParam(value = "size",defaultValue = "10",required = false)Integer size){
        Page<Question> questionPage = questionService.findPage(pageNo, size);
        model.addAttribute("questionPage",questionPage);
        return "sys/index";
    }
}
