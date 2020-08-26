package com.littlebuddha.community.sys.mapper;

import com.littlebuddha.community.base.mapper.BaseMapper;
import com.littlebuddha.community.sys.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User>{

    User selectByName(String name);

    User selectByAccountAndPassword(@Param("account")String account,@Param("password")String password);

}
