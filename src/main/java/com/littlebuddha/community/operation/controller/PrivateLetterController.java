package com.littlebuddha.community.operation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/operation")
public class PrivateLetterController {

    @GetMapping("/list/{name}")
    public String list(@PathVariable(name = "name")String name, Model model){
        if("privateLetter".equals(name)){
            model.addAttribute("name","私信");
            model.addAttribute("value",name);
            return "operation/privateLetter";
        }
        if("setting".equals(name)){
            model.addAttribute("name",name);
            return "operation/privateLetter";
        }
        return "operation/privateLetter";
    }
}
