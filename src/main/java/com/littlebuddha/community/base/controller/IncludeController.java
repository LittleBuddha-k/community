package com.littlebuddha.community.base.controller;

import com.littlebuddha.community.base.CurrentUser;
import com.littlebuddha.community.base.entity.IncludeEntity;
import com.littlebuddha.community.base.response.ResponseResult;
import com.littlebuddha.community.notice.entity.Notice;
import com.littlebuddha.community.notice.service.NoticeService;
import com.littlebuddha.community.sys.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class IncludeController {

    @Autowired
    private NoticeService noticeService;

    @ResponseBody
    @GetMapping("/include")
    public ResponseResult<IncludeEntity> findListByUserId(Notice notice, HttpSession session){
        IncludeEntity includeEntity = new IncludeEntity();
        User currentUser = CurrentUser.getCurrentUser(session);
        notice.setReceiveUser(currentUser);
        notice.setStatus(0);
        int noticeCount = noticeService.findCountByUserId(notice);
        includeEntity.setNoticeCount(noticeCount);
        return new ResponseResult<IncludeEntity>(200,includeEntity);
    }
}
