package com.littlebuddha.community.notice.service;

import com.littlebuddha.community.launch.entity.Comment;
import com.littlebuddha.community.launch.mapper.CommentMapper;
import com.littlebuddha.community.launch.mapper.QuestionMapper;
import com.littlebuddha.community.notice.entity.Notice;
import com.littlebuddha.community.notice.mapper.NoticeMapper;
import com.littlebuddha.community.notice.replyenum.ReplyEnum;
import com.littlebuddha.community.sys.entity.User;
import com.littlebuddha.community.sys.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeService {

    @Autowired
    private NoticeMapper noticeMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private CommentMapper commentMapper;

    public int findCountByUserId(Notice notice){
        return noticeMapper.selectCountByUserId(notice);
    }

    public List<Notice> findListByUserId(Notice notice){
        List<Notice> noticeList = noticeMapper.selectListByUserId(notice);
        List<User> userList = userMapper.findList(new User());
        for (Notice entity : noticeList) {
            for (User user : userList) {
                if (entity.getNoticeUser().getId().equals(user.getId())){
                    entity.setNoticeUser(user);
                }
                if (entity.getReceiveUser().getId().equals(user.getId())){
                    entity.setReceiveUser(user);
                }
            }
            giveName(entity);
        }
        return noticeList;
    }

    private void giveName(Notice entity) {
        if(entity.getNoticeType() == ReplyEnum.REPLY_QUESTION.getType()){
            entity.setNoticeName(ReplyEnum.REPLY_QUESTION.getName());
            entity.setQuestion(questionMapper.get(entity.getNoticeProject()));
        }
        if(entity.getNoticeType() == ReplyEnum.REPLY_COMMENT.getType()){
            entity.setNoticeName(ReplyEnum.REPLY_COMMENT.getName());
            Comment parentComment = commentMapper.get(entity.getNoticeProject());
            entity.setQuestion(questionMapper.get(parentComment.getParentId()));
        }
    }
}
