package com.example.springmybatisdemo.util;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

abstract class ProxyAbstractUtil {
    static String getJsonString(String url){
        String jsonString = null;
        CloseableHttpClient defaultClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        try {
            CloseableHttpResponse execute = defaultClient.execute(httpGet);
            HttpEntity entity = execute.getEntity();
            jsonString = EntityUtils.toString(entity);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            defaultClient.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonString;
    }
}
