package com.littlebuddha.community.notice.entity;

import com.littlebuddha.community.launch.entity.Comment;
import com.littlebuddha.community.launch.entity.Question;
import com.littlebuddha.community.sys.entity.User;

import java.util.Date;

public class Notice {

    private String id;//主键id
    private User noticeUser;//通知人
    private User receiveUser;//接收通知人
    private String noticeProject;//通知问题或是评论的id
    private Question question;//通知问题
    private Comment comment;//通知评论
    private Integer noticeType;//通知类型---（点赞、评论、问题。。。）
    private String noticeName;//对应通知类型的name
    private Integer status;//通知状态 0:已读 1:未读
    private String statusName;//对应通知状态的name
    private Date createDate;//创建时间

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getNoticeUser() {
        return noticeUser;
    }

    public void setNoticeUser(User noticeUser) {
        this.noticeUser = noticeUser;
    }

    public User getReceiveUser() {
        return receiveUser;
    }

    public void setReceiveUser(User receiveUser) {
        this.receiveUser = receiveUser;
    }

    public String getNoticeProject() {
        return noticeProject;
    }

    public void setNoticeProject(String noticeProject) {
        this.noticeProject = noticeProject;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public Integer getNoticeType() {
        return noticeType;
    }

    public void setNoticeType(Integer noticeType) {
        this.noticeType = noticeType;
    }

    public String getNoticeName() {
        return noticeName;
    }

    public void setNoticeName(String noticeName) {
        this.noticeName = noticeName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
