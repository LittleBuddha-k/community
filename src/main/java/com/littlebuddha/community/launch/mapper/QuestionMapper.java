package com.littlebuddha.community.launch.mapper;

import com.littlebuddha.community.base.mapper.BaseMapper;
import com.littlebuddha.community.launch.entity.Question;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface QuestionMapper extends BaseMapper<Question>{

    int getTotal();

    List<Question> getList(@Param("offset")Integer offset,@Param("size")Integer size);

    int addComments(Question question);

    int addView(Question question);

    int addAttention(Question question);

    int addReply(Question question);

    List<Question> findByTags(Question question);
}
