package com.example.springmybatisdemo.service;

import com.example.springmybatisdemo.domain.SimpleOverhaulBean;
import com.example.springmybatisdemo.mapper.SimpleOverhaulMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 12392
 */
@Service
public class SimpleOverhaulServiceImpl implements SimpleOverhaulService{

    private final SimpleOverhaulMapper mapper;

    @Autowired
    public SimpleOverhaulServiceImpl(SimpleOverhaulMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public List<SimpleOverhaulBean> getBeansHavingFuJian() {
        String emptyStr = "NULL";
        return mapper.getBeans().stream().filter(simpleOverhaulBean -> {
            String fuJian = simpleOverhaulBean.getFuJian();
            return fuJian != null && !emptyStr.equals(fuJian);
        }).collect(Collectors.toList());
    }

    @Override
    public List<SimpleOverhaulBean> getBeans() {
        return mapper.getBeans();
    }
}
