package com.xiaoai.rabbitmq.provider.drools.service.impl;

import com.xiaoai.rabbitmq.provider.drools.config.SpringContextUtil;
import com.xiaoai.rabbitmq.provider.drools.entity.ParamInfo;
import com.xiaoai.rabbitmq.provider.drools.entity.QueryParam;
import com.xiaoai.rabbitmq.provider.drools.service.ParamInfoService;
import com.xiaoai.rabbitmq.provider.drools.service.RuleEngineService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author ailiqiao
 */
@Slf4j
@Service
public class RuleEngineServiceImpl implements RuleEngineService {

    @Override
    public void executeAddRule(QueryParam param) {
        log.info("参数数据:"+param.getParamId()+";"+param.getParamSign());
        ParamInfo paramInfo = new ParamInfo() ;
        paramInfo.setParamSign(param.getParamSign());
        paramInfo.setCreateTime(new Date());
        paramInfo.setUpdateTime(new Date());
        ParamInfoService paramInfoService = (ParamInfoService) SpringContextUtil.getBean("paramInfoService") ;
        paramInfoService.insertParam(paramInfo);
    }

    @Override
    public void executeRemoveRule(QueryParam param) {
        log.info("参数数据:"+param.getParamId()+";"+param.getParamSign());
        ParamInfoService paramInfoService = (ParamInfoService) SpringContextUtil.getBean("paramInfoService") ;
        ParamInfo paramInfo = paramInfoService.selectById(param.getParamId());
        if (paramInfo != null){
            paramInfoService.removeById(param.getParamId()) ;
        }
    }

    @Override
    public void test(){
        System.out.println("this is test");
    }
}
