package com.example.springmybatisdemo.domain;

import lombok.Data;

import java.util.Date;

/**
 * @author 12392
 */
@Data
public class SimpleOverhaulBean {
    private String overhaulNumber;
    private String wayOpinion;
    private String startDate;
    private String endDate;
    private String fuJian;
    private String fdfsjzysx;

    @Override
    public String toString() {
        String str = overhaulNumber + "\t" +
                startDate + "\t" +
                endDate + "\n" +
                wayOpinion + "\n" +
                fuJian + "\n";
        if ("NULL".equals(fuJian)) {
            str = overhaulNumber + "\t" +
                    startDate + "\t" +
                    endDate + "\n" +
                    wayOpinion + "\n";
        }
        return  str;
    }
}
