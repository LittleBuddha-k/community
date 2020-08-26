package com.littlebuddha.community.launch.controller;

import com.littlebuddha.community.base.exception.errorcode.CustomizeErrorCode;
import com.littlebuddha.community.base.response.ResponseResult;
import com.littlebuddha.community.launch.entity.Comment;
import com.littlebuddha.community.launch.service.CommentService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/save")
    @ResponseBody
    public ResponseResult comment(Comment comment, HttpSession session, Model model) {
        if (session.getAttribute("currentUser") == null) {
            return ResponseResult.errorOf(CustomizeErrorCode.NO_LOGIN);
        }
        if (comment == null || StringUtils.isBlank(comment.getCommentContent())) {
            return ResponseResult.errorOf(CustomizeErrorCode.COMMENT_NOT_EMPTY);
        }
        commentService.save(comment, session);
        return ResponseResult.okOf();
    }
}
