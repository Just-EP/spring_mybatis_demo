package com.example.springmybatisdemo.util;

import com.example.springmybatisdemo.domain.BusMethodCountBean;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Field;

/**
 * @author 12392
 */
public class FileTest {
    public static void main(String[] args) {
        File file = new File("D:\\BaiduNetdiskDownload\\563w_baidubaike.json\\563w_baidubaike.json");
        int i = 0;
        int endIndex = 1000;
        try {
            int size = 2*1024*1024;
            BufferedReader reader = new BufferedReader(new FileReader(file), size);
            String s;
            while ((s = reader.readLine()) != null&&i<endIndex) {
                System.out.println(s);
                i++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
