package com.littlebuddha.community.base.utils.upload;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestFile {

    public static void main(String[] args) {
        File file = new File("E:\\upload");
        File file2 = new File("E:\\upload\\1234567.txt");
        try {
            file.mkdir();
            file2.createNewFile();
            FileInputStream is = new FileInputStream(file2);
            FileOutputStream os = new FileOutputStream(file2);
            String message = "我草泥马";
            os.write(message.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
