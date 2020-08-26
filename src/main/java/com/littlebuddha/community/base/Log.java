package com.littlebuddha.community.base;

import com.littlebuddha.community.base.entity.BaseEntity;
import com.littlebuddha.community.base.utils.Auto;
import com.littlebuddha.community.sys.entity.User;

import javax.servlet.http.HttpSession;
import java.util.Date;

public class Log<E extends BaseEntity> {

    public void setLog(E entity, HttpSession session){
        Date date = new Date();
        User currentUser = (User)session.getAttribute("currentUser");
        if(currentUser != null || currentUser.getCreateBy()!=null || currentUser.getUpdateBy() != null){
            entity.setId(Auto.getId());
            entity.setCreateBy(currentUser);
            entity.setCreateDate(date);
            entity.setUpdateBy(currentUser);
            entity.setUpdateDate(date);
        }
    }
}
