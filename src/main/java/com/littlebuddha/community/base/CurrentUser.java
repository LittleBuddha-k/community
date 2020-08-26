package com.littlebuddha.community.base;

import com.littlebuddha.community.sys.entity.User;

import javax.servlet.http.HttpSession;

public class CurrentUser {

    public static User getCurrentUser(HttpSession session){
        User currentUser = (User)session.getAttribute("currentUser");
        return currentUser;
    }
}
