package com.example.springmybatisdemo.service;

import com.example.springmybatisdemo.domain.SimpleOverhaulBean;

import java.util.List;

/**
 * @author 12392
 */
public interface SimpleOverhaulService {
    /**
     * 查询存在附件的
     * @return result
     * */
    List<SimpleOverhaulBean> getBeansHavingFuJian();
    /**
     * 查询所有的
     * @return result
     * */
    List<SimpleOverhaulBean> getBeans();
}
