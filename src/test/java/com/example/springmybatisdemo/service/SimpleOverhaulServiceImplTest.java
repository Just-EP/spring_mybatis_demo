package com.example.springmybatisdemo.service;

import com.example.springmybatisdemo.domain.SimpleOverhaulBean;
import com.tsingsoft.main.TestBusOverhaul;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest
class SimpleOverhaulServiceImplTest {

    private final SimpleOverhaulService service;

    private Pattern regex = Pattern.compile("^.*合上.*线.*开关.*$");
    private static Pattern timeStrRegex = Pattern.compile("^.*\\(.*[0-2]?[0-9]:[0-6][0-9]\\).*$");
    private static Pattern timeRegex = Pattern.compile("^[0-2]?[0-9]:[0-6][0-9]$");

    @Autowired
    SimpleOverhaulServiceImplTest(SimpleOverhaulService service) {
        this.service = service;
    }

    @Test
    void getBeans() {
        List<SimpleOverhaulBean> beans = service.getBeans();
        List<SimpleOverhaulBean> collect = beans.stream().filter(simpleOverhaulBean -> {
            String fuJian = simpleOverhaulBean.getFuJian();
            String opinion = simpleOverhaulBean.getWayOpinion();
            return (fuJian != null && !"NULL".equals(fuJian)) || opinion != null;
        }).collect(Collectors.toList());

        File file = new File("D:\\a.txt");
        BufferedWriter bufferedWriter;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(file));
            for (SimpleOverhaulBean simpleOverhaulBean : collect) {
                String overhaulNumber = simpleOverhaulBean.getOverhaulNumber();
                TestBusOverhaul.analyseByOverhaulNumber(overhaulNumber);
                String string = simpleOverhaulBean.toString();
                bufferedWriter.write(string);
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getTimeStr(String opinion) {
        if (timeStrRegex.matcher(opinion).find()) {
            System.out.println(opinion);
            int lastIndex = opinion.lastIndexOf(":");
            int startIndex = lastIndex - 2;
            int endIndex = lastIndex + 3;
            if (startIndex >= 0 && endIndex <= opinion.length()) {
                String timeStr = opinion.substring(startIndex, endIndex);
                if (!timeRegex.matcher(timeStr).find()) {
                    timeStr = timeStr.substring(1);
                    if (timeStr.length() < 5) {
                        timeStr = "0" + timeStr;
                    }
                }
                if (timeRegex.matcher(timeStr).find()) {
                    return timeStr;
                }
            }
        }
        return null;
    }
}