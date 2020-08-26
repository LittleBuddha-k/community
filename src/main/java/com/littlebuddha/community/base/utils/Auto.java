package com.littlebuddha.community.base.utils;

import java.util.UUID;

public class Auto {

    public static String getId(){
        String id = UUID.randomUUID().toString().replace("-", "");
        return id;
    }
}
