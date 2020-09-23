package com.xiaoai.rabbitmq.provider.drools.service;

import com.xiaoai.rabbitmq.provider.drools.entity.QueryParam;

public interface RuleEngineService {

    void executeAddRule (QueryParam param) ;

    void executeRemoveRule (QueryParam param) ;

    void test();
}
