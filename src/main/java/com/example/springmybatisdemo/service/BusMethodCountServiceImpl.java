package com.example.springmybatisdemo.service;

import com.example.springmybatisdemo.domain.BusMethodCountBean;
import com.example.springmybatisdemo.mapper.BusMethodCountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 12392
 */
@Component
public class BusMethodCountServiceImpl implements BusMethodCountService{

    private final BusMethodCountMapper mapper;

    @Autowired
    public BusMethodCountServiceImpl(BusMethodCountMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public void getBeans() {
        List<BusMethodCountBean> busMethodCountBeans = mapper.queryBeans();
        List<Long> collect = busMethodCountBeans.stream().map(BusMethodCountBean::getBusId).collect(Collectors.toList());
        List<Long> collect2 = busMethodCountBeans.stream().map(BusMethodCountBean::getBusId).collect(Collectors.toList());
        BusMethodCountBean a = new BusMethodCountBean();
        List<BusMethodCountBean> list = new ArrayList<>();
        list.add(a);
        System.out.println(list);

    }
}
