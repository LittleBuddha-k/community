package com.littlebuddha.community.launch.service;

import com.littlebuddha.community.base.Log;
import com.littlebuddha.community.base.exception.errorcode.CustomizeErrorCode;
import com.littlebuddha.community.base.exception.serviceexception.CustomizeException;
import com.littlebuddha.community.base.response.CommentEnum;
import com.littlebuddha.community.base.utils.Auto;
import com.littlebuddha.community.launch.entity.Comment;
import com.littlebuddha.community.launch.entity.Question;
import com.littlebuddha.community.launch.mapper.CommentMapper;
import com.littlebuddha.community.launch.mapper.QuestionMapper;
import com.littlebuddha.community.notice.entity.Notice;
import com.littlebuddha.community.notice.mapper.NoticeMapper;
import com.littlebuddha.community.notice.replyenum.ReplyEnum;
import com.littlebuddha.community.notice.replyenum.StatusEnum;
import com.littlebuddha.community.sys.entity.User;
import com.littlebuddha.community.sys.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Service
public class CommentService {
    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private NoticeMapper noticeMapper;

    public List<Comment> findListByParentId(String parentId){
        List<Comment> questionComments = commentMapper.findListByParentId(parentId);
        if(questionComments.size() == 0){
            return questionComments;
        }
        List<User> users = userMapper.findList(new User());
        List<Comment> need = null;
        for (Comment questionComment : questionComments) {
            List<Comment> childrenComments = commentMapper.findListByParentId(questionComment.getId());
            questionComment.setChildrenComments(childrenComments);
            for (User user : users) {
                if(questionComment.getCreateBy().getId().equals(user.getId())){
                    questionComment.setCreateBy(user);
                }
            }
        }
        return questionComments;
    }

    @Transactional
    public void save(Comment comment, HttpSession session) {
        if(comment.getParentId() == null || comment.getParentId() == ""){
            throw new CustomizeException(CustomizeErrorCode.NO_SUCH_DATA);
        }
        if(comment.getType() == null || !CommentEnum.isExist(comment.getType())){
            throw new CustomizeException(CustomizeErrorCode.TYPE_WRONG);
        }
        if(comment.getType() == CommentEnum.COMMENT.getType()){
            //评论
            Comment parentComment = commentMapper.get(comment.getParentId());
            if(parentComment == null){
                throw new CustomizeException(CustomizeErrorCode.COMMENT_NOT_EXIST);
            }
            comment.setParentId(parentComment.getId());
            Log log = new Log();
            log.setLog(comment,session);
            comment.setCommentCount(0);
            commentMapper.insert(comment);
            parentComment.setCommentCount(1);
            commentMapper.addCommentCount(parentComment);
            Notice notice = createNotice(comment, parentComment.getCreateBy().getId(), ReplyEnum.REPLY_COMMENT, StatusEnum.UNREAD);
            noticeMapper.insert(notice);
        }else {
            //问题
            Question question = questionMapper.get(comment.getParentId());
            if(question == null){
                throw new CustomizeException(CustomizeErrorCode.QUESTION_NOT_EXIST);
            }
            comment.setParentId(question.getId());
            Log log = new Log();
            log.setLog(comment,session);
            comment.setCommentCount(0);
            commentMapper.insert(comment);
            question.setComments(1);
            questionMapper.addComments(question);
            Notice notice = createNotice(comment, question.getCreateBy().getId(), ReplyEnum.REPLY_QUESTION, StatusEnum.UNREAD);
            noticeMapper.insert(notice);
        }
    }

    private Notice createNotice(Comment comment, String id, ReplyEnum replyEnum, StatusEnum statusEnum) {
        Notice notice = new Notice();
        notice.setId(Auto.getId());
        notice.setNoticeUser(comment.getCreateBy());
        User receiveUser = userMapper.get(id);
        notice.setReceiveUser(receiveUser);
        notice.setNoticeProject(comment.getParentId());
        notice.setNoticeType(replyEnum.getType());
        notice.setStatus(statusEnum.getStatus());
        notice.setCreateDate(new Date());
        return notice;
    }
}
