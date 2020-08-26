package com.littlebuddha.community.sys.service;

import com.littlebuddha.community.base.utils.Auto;
import com.littlebuddha.community.base.utils.Local;
import com.littlebuddha.community.base.utils.date.DateUtil;
import com.littlebuddha.community.sys.entity.User;
import com.littlebuddha.community.sys.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    User user = null;

    public void register(String account,String password){
        user = new User();
        user.setId(Auto.getId());
        user.setAccount(account);
        user.setPassword(password);
        user.setCreateDate(DateUtil.currentDate());
        user.setUpdateDate(DateUtil.currentDate());
        user.setIp(Local.getHostIp());
        user.setIpName(Local.getHostName());
        int row = userMapper.insert(user);
    }

    public User login(String account, String password) {
        User user = userMapper.selectByAccountAndPassword(account, password);
        if(user == null){
            User newUser = new User();
            return newUser;
        }
        return user;
    }
}
