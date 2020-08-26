package com.littlebuddha.community.launch.service;

import com.littlebuddha.community.base.CurrentUser;
import com.littlebuddha.community.base.Log;
import com.littlebuddha.community.base.exception.errorcode.CustomizeErrorCode;
import com.littlebuddha.community.base.exception.serviceexception.CustomizeException;
import com.littlebuddha.community.base.page.Page;
import com.littlebuddha.community.base.utils.Auto;
import com.littlebuddha.community.launch.entity.Question;
import com.littlebuddha.community.launch.mapper.QuestionMapper;
import com.littlebuddha.community.sys.entity.User;
import com.littlebuddha.community.sys.mapper.UserMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private UserMapper userMapper;

    public Question get(String id) {
        Question question = questionMapper.get(id);
        if (question == null) {
            throw new CustomizeException(CustomizeErrorCode.NO_SUCH_DATA);
        }
        User user = userMapper.get(question.getCreateBy().getId());
        question.setCreateBy(user);
        return question;
    }

    public Page<Question> findPage(Integer pageNo, Integer size) {
        Page page = new Page();
        Integer offset = size * (pageNo - 1);
        List<Question> questionList = questionMapper.getList(offset, size);
        List<User> userList = userMapper.findList(new User());
        int total = questionMapper.getTotal();
        for (User uEntity : userList) {
            for (Question qEntity : questionList) {
                if (qEntity.getCreateBy().getId().equals(uEntity.getId())) {
                    qEntity.setCreateBy(uEntity);
                }
            }
        }
        page.setPageNation(total, pageNo, size);
        page.setList(questionList);
        return page;
    }

    public List<Question> findByTags(String id, String tags) {
        Question question = new Question();
        tags = tags.replace("、", "|");
        if (tags.contains("+")) {
            tags = tags.replace("+", "");
        }
        question.setId(id);
        question.setTags(tags);
        List<Question> list = questionMapper.findByTags(question);
        return list;
    }

    @Transactional
    public void save(Question question, HttpSession session) {
        User currentUser = CurrentUser.getCurrentUser(session);
        if(StringUtils.isBlank(question.getId())){
            Log<Question> log = new Log<>();
            log.setLog(question, session);
            question.setComments(0);
            question.setView(0);
            question.setAttention(0);
            question.setReply(0);
            questionMapper.insert(question);
        }else {
            questionMapper.update(question);
        }
    }

    public void addCount(String id) {
        Question question = questionMapper.get(id);
        question.setView(1);
        questionMapper.addView(question);
    }
}
