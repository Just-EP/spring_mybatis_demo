package com.example.springmybatisdemo.domain;

import lombok.Data;

@Data
public class ViewBean implements Cloneable{
    private String startYmd;
    private String endYmd;
    private String busId;
    private String isNewValue;

    @Override
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
}
