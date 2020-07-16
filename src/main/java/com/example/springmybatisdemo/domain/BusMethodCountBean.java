package com.example.springmybatisdemo.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * @author 12392
 */
@Getter
@Setter
public class BusMethodCountBean {
    private Long busId;
    private String name;
    private String methodId;
    private Integer count;
}
