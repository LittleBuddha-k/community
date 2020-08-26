package com.littlebuddha.community.launch.mapper;

import com.littlebuddha.community.base.mapper.BaseMapper;
import com.littlebuddha.community.launch.entity.Comment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentMapper extends BaseMapper<Comment> {

    List<Comment> findListByParentId(String parentId);

    void addCommentCount(Comment comment);
}
