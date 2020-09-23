package com.xiaoai.rabbitmq.provider.drools.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.xiaoai.rabbitmq.provider.drools.entity.ParamInfo;

public interface ParamInfoService extends IService<ParamInfo> {

    ParamInfo selectById (String paramId) ;

    void insertParam (ParamInfo paramInfo) ;
}
