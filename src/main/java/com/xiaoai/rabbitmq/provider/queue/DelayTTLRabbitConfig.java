package com.xiaoai.rabbitmq.provider.queue;

import com.xiaoai.rabbitmq.provider.constant.RabbitMqConstant;
import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ailiqiang
 * @date 2020/9/19
 * @desc Rabbit 延时队列配置类
*/
@Configuration
public class DelayTTLRabbitConfig {

    @Bean("delayExchage")
    CustomExchange delayExchage(){

        Map<String,Object> args = new HashMap<>();
        args.put("x-delayed-type","direct");
        //设置统一过期时间
        //args.put("x-message-ttl","6000");
        //属性参数 交换机名称 交换机类型 是否持久化 是否自动删除 配置参数
        return new CustomExchange(RabbitMqConstant.EXCHANGE_DELAY_PROCESS,"x-delayed-message",true,false,args);
    }

    @Bean("delayProcessQueue")
    Queue delayProcessQueue(){
        return new Queue(RabbitMqConstant.QUEUE_DELAY_PROCESS);
    }

    @Bean
    Binding delayOnBinding(@Qualifier("delayProcessQueue") Queue delayProcessQueue, @Qualifier("delayExchage") Exchange delayExchage){
        return BindingBuilder.bind(delayProcessQueue).to(delayExchage).with(RabbitMqConstant.EXCHANGE_BINDING_PROCESS_RULE).noargs();
    }
}
