package com.example.springmybatisdemo.service;

import com.example.springmybatisdemo.domain.BusBean;
import com.example.springmybatisdemo.domain.StationBean;
import com.example.springmybatisdemo.mapper.BusMapper;
import com.example.springmybatisdemo.mapper.StationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StationServiceImpl implements StationService{

    private final StationMapper mapper;
    private final BusMapper busMapper;

    @Autowired
    public StationServiceImpl(StationMapper mapper, BusMapper busMapper) {
        this.mapper = mapper;
        this.busMapper = busMapper;
    }
    @Override
    @Bean
    public String makeMdStringFromBean() {
        List<StationBean> beans = mapper.getBeans();
        StringBuilder stringBuilder = new StringBuilder();
        for (StationBean bean : beans) {
            stringBuilder.append("- [ ]  ").append(bean.getStationId()).append(" ").append(bean.getStationName()).append("  ").append("\n");
        }
//        System.out.println(stringBuilder);
        return stringBuilder.toString();
    }

    @Override
    @Bean
    public String makeSubBusMdStringFromBean() {
        List<StationBean> stationBeans = mapper.getBeans();
        StringBuilder stringBuilder = new StringBuilder();
        for (StationBean stationBean : stationBeans) {
            List<BusBean> busBeans = busMapper.getBeansFromStationId(stationBean);
            for (BusBean busBean : busBeans) {
                stringBuilder.append("- [ ]  ").append(busBean.getBusId()).append(" ").append(busBean.getBusName()).append("  ").append("\n");
            }
            stringBuilder.append("\n");
        }
        System.out.println(stringBuilder);
        return stringBuilder.toString();
    }
}
