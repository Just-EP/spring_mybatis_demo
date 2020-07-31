package com.example.springmybatisdemo.demo;

import com.example.springmybatisdemo.domain.ProxyIpBean;
import com.example.springmybatisdemo.util.ProxyUtil;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class ProxyDemo {

    public static void main(String[] args) {
        for (int i = 0; i < 6; i++) {
            test();
        }
    }

    private static void test(){
        ProxyIpBean oneProxy = ProxyUtil.getOneProxy();
        String proxyAddress = oneProxy.getProxy();
        HttpHost proxy;
        if (proxyAddress.contains(":")) {
            proxy = new HttpHost(proxyAddress.split(":")[0],Integer.parseInt(proxyAddress.split(":")[1]));
        }else{
            proxy = new HttpHost(proxyAddress);
        }
        CloseableHttpClient proxyClient = HttpClients.custom().setProxy(proxy).build();
        HttpGet httpGet = new HttpGet("http://www.ip138.com/");
        httpGet.setHeader("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/84.0.4147.89 Safari/537.36");
        try {
            CloseableHttpResponse execute = proxyClient.execute(httpGet);
            int code = execute.getStatusLine().getStatusCode();
            System.out.println(proxyAddress+"/"+code);
            HttpEntity entity = execute.getEntity();
            String s = EntityUtils.toString(entity);
            System.out.println(s);
            EntityUtils.consume(entity);
            proxyClient.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
