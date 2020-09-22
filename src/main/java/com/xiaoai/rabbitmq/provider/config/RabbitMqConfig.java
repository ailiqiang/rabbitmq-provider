package com.xiaoai.rabbitmq.provider.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ailiqiang
 * @date 2020/9/18
 * @desc RabbitMq配置类
*/
@Slf4j
@Configuration
public class RabbitMqConfig {

    @Bean("rabbitTemplate")
    public RabbitTemplate createRabbitTemplate(ConnectionFactory connectionFactory){

        RabbitTemplate rabbitTemplate = new RabbitTemplate();
        rabbitTemplate.setConnectionFactory(connectionFactory);

        //设置rabbitmq消息序列化方式
        //注：由于RabbitTemplate默认采用的是JDK的MessageConvert,使用默认的JDK序列化规则
        //注：所以需要更改MessageConvert，更改为JSON的序列化规则
        rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());

        //设置开启Mandatory,才能触发回调函数,无论消息推送结果怎么样都强制调用回调函数
        rabbitTemplate.setMandatory(true);

        //交换机消息发送确认回调
        rabbitTemplate.setConfirmCallback(new RabbitTemplate.ConfirmCallback() {
            @Override
            public void confirm(CorrelationData correlationData, boolean b, String s) {

                if(!b){
                    log.info("[RabbitMq][生产者][交换机确认消息回调][错误信息:相关数据:{}]",correlationData);
                    log.info("[RabbitMq][生产者][交换机确认消息回调][错误信息:确认情况:{}]",b);
                    log.info("[RabbitMq][生产者][交换机确认消息回调][错误信息:原因:{}]",s);

                    throw new RuntimeException("消息发送失败:" + s);
                }
            }
        });

        //队列消息发送确认回调
        rabbitTemplate.setReturnCallback(new RabbitTemplate.ReturnCallback() {
            @Override
            public void returnedMessage(Message message, int i, String s, String s1, String s2) {

                log.info("[RabbitMq][生产者][队列确认消息回调][错误信息:消息:{}]",message);
                log.info("[RabbitMq][生产者][队列确认消息回调][错误信息:回应码:{}]",i);
                log.info("[RabbitMq][生产者][队列确认消息回调][错误信息:回应消息:{}]",s);
                log.info("[RabbitMq][生产者][队列确认消息回调][错误信息:交换机:{}]",s1);
                log.info("[RabbitMq][生产者][队列确认消息回调][错误信息:路由键:{}]",s2);

                throw new RuntimeException("消息发送失败:message" + message
                        + " 回应码:" + i
                        + " 回应消息:" + s
                        + " 交换机:" + s1
                        + " 路由键" + s2);
            }
        });

        return rabbitTemplate;
    }

    @Bean("rabbitDelayTemplate")
    public RabbitTemplate rabbitDelayTemplate(ConnectionFactory connectionFactory){

        RabbitTemplate rabbitTemplate = new RabbitTemplate();
        rabbitTemplate.setConnectionFactory(connectionFactory);

        //设置rabbitmq消息序列化方式
        //注：由于RabbitTemplate默认采用的是JDK的MessageConvert,使用默认的JDK序列化规则
        //注：所以需要更改MessageConvert，更改为JSON的序列化规则
        rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());

        //设置开启Mandatory,才能触发回调函数,无论消息推送结果怎么样都强制调用回调函数
        rabbitTemplate.setMandatory(false);

        //交换机消息发送确认回调
        rabbitTemplate.setConfirmCallback(new RabbitTemplate.ConfirmCallback() {
            @Override
            public void confirm(CorrelationData correlationData, boolean b, String s) {

                if(!b){
                    log.info("[RabbitMq][生产者][交换机确认消息回调][错误信息:相关数据:{}]",correlationData);
                    log.info("[RabbitMq][生产者][交换机确认消息回调][错误信息:确认情况:{}]",b);
                    log.info("[RabbitMq][生产者][交换机确认消息回调][错误信息:原因:{}]",s);

                    throw new RuntimeException("消息发送失败:" + s);
                }
            }
        });

        //队列消息发送确认回调
        rabbitTemplate.setReturnCallback(new RabbitTemplate.ReturnCallback() {
            @Override
            public void returnedMessage(Message message, int i, String s, String s1, String s2) {

                log.info("[RabbitMq][生产者][队列确认消息回调][错误信息:消息:{}]",message);
                log.info("[RabbitMq][生产者][队列确认消息回调][错误信息:回应码:{}]",i);
                log.info("[RabbitMq][生产者][队列确认消息回调][错误信息:回应消息:{}]",s);
                log.info("[RabbitMq][生产者][队列确认消息回调][错误信息:交换机:{}]",s1);
                log.info("[RabbitMq][生产者][队列确认消息回调][错误信息:路由键:{}]",s2);

                throw new RuntimeException("消息发送失败:message" + message
                        + " 回应码:" + i
                        + " 回应消息:" + s
                        + " 交换机:" + s1
                        + " 路由键" + s2);
            }
        });

        return rabbitTemplate;
    }
}
