package com.example.springmybatisdemo.service;

import com.example.springmybatisdemo.domain.ViewBean;
import com.example.springmybatisdemo.mapper.IndexMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IndexServiceImpl implements IndexService{

    private final IndexMapper mapper;

    public IndexServiceImpl(IndexMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public boolean doRemove(ViewBean bean) {
        System.out.println(bean);
        List<ViewBean> viewBeans = new ArrayList<>();
        String busIdStr = bean.getBusId();
        if (busIdStr.contains(",")) {
            for (String busId : busIdStr.split(",")) {
                ViewBean clone = (ViewBean) bean.clone();
                if (clone != null) {
                    clone.setBusId(busId);
                    viewBeans.add(clone);
                }
            }
        }else{
            viewBeans.add(bean);
        }
        System.out.println(viewBeans);
        for (ViewBean viewBean : viewBeans) {
            mapper.delete(viewBean);
        }
        return false;
    }
}
