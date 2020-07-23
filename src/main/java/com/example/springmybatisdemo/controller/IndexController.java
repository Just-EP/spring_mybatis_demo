package com.example.springmybatisdemo.controller;

import com.example.springmybatisdemo.domain.ViewBean;
import com.example.springmybatisdemo.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@EnableAutoConfiguration
public class IndexController {

    private final IndexService service;

    public IndexController(IndexService service) {
        this.service = service;
    }

    @RequestMapping("/")
    public String index(){
        return "index.html";
    }

    @RequestMapping("/remove")
    public String remove(ViewBean bean){
        boolean result = service.doRemove(bean);
        return "";
    }
}
