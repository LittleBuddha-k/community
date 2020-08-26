package com.littlebuddha.community.notice.controller;

import com.littlebuddha.community.base.CurrentUser;
import com.littlebuddha.community.notice.entity.Notice;
import com.littlebuddha.community.notice.service.NoticeService;
import com.littlebuddha.community.sys.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/notice")
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    @GetMapping("/list")
    public String notice(Notice notice,HttpSession session,Model model){
        User currentUser = CurrentUser.getCurrentUser(session);
        notice.setReceiveUser(currentUser);
        notice.setStatus(0);
        List<Notice> unReadList = noticeService.findListByUserId(notice);
        model.addAttribute("unReadList",unReadList);
        return "notice/notice";
    }
}
