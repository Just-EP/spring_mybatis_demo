package com.example.springmybatisdemo.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.parser.ParserConfig;
import com.example.springmybatisdemo.domain.ProxyIpBean;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.List;

public class ProxyUtil extends ProxyAbstractUtil{

    private static String queryUrl = null;

    public static List<ProxyIpBean> getAllProxies(){
        queryUrl = "http://127.0.0.1:5010/get_all/";
        String jsonString = getJsonString(queryUrl);
        return JSON.parseArray(jsonString, ProxyIpBean.class);
    }

    public static ProxyIpBean getOneProxy(){
        queryUrl = "http://127.0.0.1:5010/get/";
        String jsonString = getJsonString(queryUrl);
        return JSON.parseObject(jsonString,ProxyIpBean.class);
    }
}
