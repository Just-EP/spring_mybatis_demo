package com.example.springmybatisdemo.util;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class LogAnalyse {

    public static String getCount(){
//        File file = new File("C:\\Users\\12392\\Desktop\\beforelog.txt");
        File file = new File("C:\\Users\\12392\\Desktop\\afterlog.txt");
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String s;
            List<String> strings = new ArrayList<>();
            List<Integer> indexes = new ArrayList<>();
            List<Integer> counts = new ArrayList<>();
            while ((s = reader.readLine()) != null) {
                strings.add(s);
            }
            for (int i = 0; i < strings.size(); i++) {
                String string = strings.get(i);
                if (string.contains("检修单编号")&&string.contains("RepairScheduleCollectMain")) {
                    indexes.add(i);
                }
            }
            for (Integer index : indexes) {
                String s1 = strings.get(index);
                int countIndex = index -1;
                String[] split = s1.split(":");
                if (countIndex != -1) {
                    String count = strings.get(countIndex);
                    counts.add(Integer.parseInt(count.split(":")[1]));
//                    System.out.println(count);
                    System.out.println("+"+Integer.parseInt(count.split(":")[1]));
                }
                System.out.println(split[5]);
            }
            String count = strings.get(strings.size() - 3);
            counts.add(Integer.parseInt(count.split(":")[1]));
            int totalCount = 0;
            for (Integer integer : counts) {
                totalCount+=integer;
            }
//            System.out.println(count);
            System.out.println("+"+Integer.parseInt(count.split(":")[1]));
            System.out.println(totalCount);
            return String.valueOf(totalCount);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        getCount();
    }
}
