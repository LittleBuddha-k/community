package com.littlebuddha.community.launch.controller;

import com.littlebuddha.community.launch.entity.Comment;
import com.littlebuddha.community.launch.entity.Question;
import com.littlebuddha.community.launch.service.CommentService;
import com.littlebuddha.community.launch.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private CommentService commentService;

    @ModelAttribute
    public Question get(@RequestParam(name = "id", required = false) String id) {
        Question question = null;
        if (id != null && id.length() > 0 && id != "") {
            question = questionService.get(id);
        } else {
            return new Question();
        }
        return question;
    }

    /*发布问题*/
    @GetMapping("/form")
    public String questionForm(Question question, Model model) {
        model.addAttribute("question", question);
        return "launch/questionForm";
    }

    @GetMapping("/detail/{id}")
    public String questionDetail(@PathVariable(name = "id") String id, Model model) {
        //查询问题,返回问题
        Question question = questionService.get(id);
        questionService.addCount(id);
        model.addAttribute("question", question);
        //查询与问题相关的评论，返回评论
        List<Comment> comments = commentService.findListByParentId(question.getId());
        model.addAttribute("comments", comments);
        List<Question> relativeQuestion = questionService.findByTags(question.getId(), question.getTags());
        model.addAttribute("relativeQuestion", relativeQuestion);
        return "launch/questionDetail";
    }

    @PostMapping("/save")
    public String add(Question question, HttpSession session, Model model) {
        model.addAttribute("question", question);
        if (question.getTitle() == null || question.getTitle() == "") {
            model.addAttribute("message1", "標題不能爲空");
            return "launch/questionForm";
        }
        if (question.getContent() == null || question.getContent() == "") {
            model.addAttribute("message2", "内容不能爲空");
            return "launch/questionForm";
        }
        if (question.getTags() == null || question.getTags() == "") {
            model.addAttribute("message3", "標簽不能爲空");
            return "launch/questionForm";
        }
        if (session.getAttribute("currentUser") == null) {
            model.addAttribute("error", "用户未登录,请登陆过后在操作！！！");
        }
        questionService.save(question, session);
        return "redirect:/index";
    }
}
