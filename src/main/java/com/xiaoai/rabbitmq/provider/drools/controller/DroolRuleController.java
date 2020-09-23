package com.xiaoai.rabbitmq.provider.drools.controller;

import com.xiaoai.rabbitmq.provider.drools.entity.QueryParam;
import com.xiaoai.rabbitmq.provider.drools.entity.RuleResult;
import com.xiaoai.rabbitmq.provider.drools.entity.UserInfo;
import com.xiaoai.rabbitmq.provider.drools.service.RuleEngineService;
import lombok.extern.slf4j.Slf4j;
import org.kie.api.runtime.KieSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Slf4j
@Controller
public class DroolRuleController {

    @Resource
    private KieSession kieSession;

    @Resource
    private RuleEngineService ruleEngineService ;

    @RequestMapping("/rule")
    @ResponseBody
    public String rule(){

        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("艾李强");
        userInfo.setTelephone("13618607409");

        QueryParam queryParam1 = new QueryParam() ;
        queryParam1.setParamId("1");
        queryParam1.setParamSign("+");

        // 入参
        kieSession.insert(userInfo);
        kieSession.insert(queryParam1);
        kieSession.setGlobal("log",log);
        kieSession.insert(ruleEngineService);

        // 返参
        RuleResult resultParam = new RuleResult() ;
        kieSession.insert(resultParam) ;

        int firedCount = kieSession.fireAllRules();

        System.out.println("返回数据：" + resultParam.toString());

        System.out.println("触发了" + firedCount + "条规则");

        return "触发了" + firedCount + "条规则";
    }


    @RequestMapping("/ruleTest")
    @ResponseBody
    public String param (){

        QueryParam queryParam1 = new QueryParam() ;
        queryParam1.setParamId("1");
        queryParam1.setParamSign("+");

        QueryParam queryParam2 = new QueryParam() ;
        queryParam2.setParamId("2");
        queryParam2.setParamSign("-");

        // 入参
        kieSession.insert(queryParam1) ;
        kieSession.insert(queryParam2) ;
        kieSession.setGlobal("log",log);
        kieSession.setGlobal("service",ruleEngineService);
        kieSession.insert(ruleEngineService) ;

        // 返参
        RuleResult resultParam = new RuleResult() ;
        kieSession.insert(resultParam) ;

        int firedCount = kieSession.fireAllRules() ;

        return "触发了" + firedCount + "条规则";

    }

}
