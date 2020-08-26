package com.littlebuddha.community.base.utils.date;

import java.util.Date;

public class DateUtil {

    public static void main(String[] args) {
        System.out.println(currentDate());
    }

    private static Date date = new Date();

    public static Date currentDate(){
        return date;
    }
}
