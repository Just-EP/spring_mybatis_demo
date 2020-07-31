package com.example.springmybatisdemo.domain;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.Date;

@Data
public class ProxyIpBean {
    /**
     * check_count : 4
     * fail_count : 0
     * last_status : 1
     * last_time : 2020-07-29 10:15:26
     * proxy : 165.225.200.77:10605
     * region :
     * source :
     * type :
     */

    @JSONField(name = "check_count")
    private Integer checkCount;
    @JSONField(name = "fail_count")
    private Integer failCount;
    @JSONField(name = "last_status")
    private Integer lastStatus;
    @JSONField(name = "last_time")
    private String lastTime;

    private String proxy;

    private String region;

    private String source;

    private String type;
}
