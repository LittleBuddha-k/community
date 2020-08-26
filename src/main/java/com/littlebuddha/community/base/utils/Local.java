package com.littlebuddha.community.base.utils;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Local {

    public static String getHostIp() {
        String ip = null;
        try {
            ip = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return ip;
    }

    public static String getHostName(){
        String name = null;
        try {
            name = InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return name;
    }
}
