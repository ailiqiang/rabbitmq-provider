//package com.xiaoai.rabbitmq.provider.queue;
//
//import org.springframework.amqp.core.*;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
///**
// * @author ailiqiang
// * @date 2020/9/19
// * @desc Rabbit 延时队列配置类
//*/
//@Configuration
//public class DelayDLXRabbitConfig {
//
//    /** 定义延时队列名称 **/
//    public final static String DELAY_QUEUE_PER_QUEUE_TTL_NAME = "delay_queue_per_queue_ttl";
//
//    /** 定义延时过期处理队列名称 **/
//    public final static String DELAY_PROCESS_QUEUE_NAME = "delay_process_queue";
//
//    /** 定义延时过期处理交换机名称 **/
//    public final static String DELAY_EXCHANGE_NAME = "delay_exchange";
//
//    public final static String DELAY_ON_EXCHANGE_NAME = "delay_on_exchange";
//
//    /** 定义路由键 **/
//    public final static String DELAY_ROUTING_NAME = "delay_routing";
//
//    /** 定义延时队列过期时间 **/
//    public final static int QUEUE_EXPIRATION = 10000;
//
//    @Bean
//    Queue delayQueuePerQueueTTL(){
//
//        return QueueBuilder.durable(DELAY_QUEUE_PER_QUEUE_TTL_NAME)
//                //设置延时队列的死信路由交换机
//                .withArgument("x-dead-letter-exchange",DELAY_EXCHANGE_NAME )
//                //设置路由键
//                .withArgument("x-dead-letter-routing-key",DELAY_ROUTING_NAME)
//                //设置延时队列过期时间
//                .withArgument("x-message-ttl",QUEUE_EXPIRATION)
//                .build();
//    }
//
//    @Bean
//    Queue delayProcessQueue(){
//        return new Queue(DELAY_PROCESS_QUEUE_NAME);
//    }
//
//    @Bean
//    DirectExchange delayExchange(){
//        return new DirectExchange(DELAY_EXCHANGE_NAME);
//    }
//
//    @Bean
//    DirectExchange delayOnExchange(){
//        return new DirectExchange(DELAY_ON_EXCHANGE_NAME);
//    }
//
//    @Bean
//    Binding dlxBinding(Queue delayProcessQueue, Exchange delayExchange){
//        return BindingBuilder.bind(delayProcessQueue).to(delayExchange).with(DELAY_ROUTING_NAME).noargs();
//    }
//
//    @Bean
//    Binding delayOnBinding(){
//        return BindingBuilder.bind(delayQueuePerQueueTTL()).to(delayOnExchange()).with(DELAY_ROUTING_NAME);
//    }
//}
