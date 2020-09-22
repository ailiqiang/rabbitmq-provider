package com.xiaoai.rabbitmq.provider.queue;

import com.xiaoai.rabbitmq.provider.constant.RabbitMqConstant;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ailiqiang
 * @date 2020/9/16
 * @desc 扇形交换机队列配置类
*/
@Configuration
public class FanoutRabbitConfig {

    /**
     *  创建三个队列 ：fanout.A   fanout.B  fanout.C
     *  将三个队列都绑定在交换机 fanoutExchange 上
     *  因为是扇型交换机, 路由键无需配置,配置也不起作用
     */
    @Bean
    public Queue queueA(){ return new Queue(RabbitMqConstant.QUEUE_FANOUT_A); }

    @Bean
    public Queue queueB(){
        return new Queue(RabbitMqConstant.QUEUE_FANOUT_B);
    }

    @Bean
    public Queue queueC(){
        return new Queue(RabbitMqConstant.QUEUE_FANOUT_C);
    }

    @Bean
    FanoutExchange fanoutExchange(){
        return new FanoutExchange(RabbitMqConstant.EXCHANGE_FANOUT_ORDERS);
    }

    @Bean
    Binding bindingExchangeA(){
        return BindingBuilder.bind(queueA()).to(fanoutExchange());
    }

    @Bean
    Binding bindingExchangeB(){
        return BindingBuilder.bind(queueB()).to(fanoutExchange());
    }

    @Bean
    Binding bindingExchangeC(){
        return BindingBuilder.bind(queueC()).to(fanoutExchange());
    }

}
