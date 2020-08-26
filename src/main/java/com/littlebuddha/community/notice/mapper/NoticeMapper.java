package com.littlebuddha.community.notice.mapper;

import com.littlebuddha.community.base.mapper.BaseMapper;
import com.littlebuddha.community.notice.entity.Notice;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NoticeMapper extends BaseMapper<Notice> {

    int selectCountByUserId(Notice notice);

    List<Notice> selectListByUserId(Notice notice);
}
