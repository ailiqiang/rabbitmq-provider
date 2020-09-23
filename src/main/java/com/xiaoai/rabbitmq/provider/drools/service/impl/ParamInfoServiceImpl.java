package com.xiaoai.rabbitmq.provider.drools.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaoai.rabbitmq.provider.drools.entity.ParamInfo;
import com.xiaoai.rabbitmq.provider.drools.mapper.ParamInfoMapper;
import com.xiaoai.rabbitmq.provider.drools.service.ParamInfoService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Slf4j
@Service("paramInfoService")
public class ParamInfoServiceImpl extends ServiceImpl<ParamInfoMapper, ParamInfo> implements ParamInfoService {

    @Resource
    private ParamInfoMapper paramInfoMapper ;

    @Override
    public ParamInfo selectById (String paramId){
        ParamInfo paramInfo = paramInfoMapper.selectById(paramId) ;
        log.info("ParamInfoServiceImpl-Sign：{}",paramInfo.getParamSign());
        return paramInfo ;
    }

    @Override
    public void insertParam(ParamInfo paramInfo) {
        paramInfoMapper.insertParam(paramInfo) ;
    }

}
