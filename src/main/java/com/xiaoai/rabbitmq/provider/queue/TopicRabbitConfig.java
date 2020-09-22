package com.xiaoai.rabbitmq.provider.queue;

import com.xiaoai.rabbitmq.provider.constant.RabbitMqConstant;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ailiqiang
 * @date 2020/9/16
 * @desc 主题交换机队列配置类
*/
@Configuration
public class TopicRabbitConfig {

    @Bean
    public Queue manQueue(){
        return new Queue(RabbitMqConstant.QUEUE_TOPIC_MAN);
    }

    @Bean
    public Queue womanQueue(){
        return new Queue(RabbitMqConstant.QUEUE_TOPIC_WOMAN);
    }

    @Bean
    TopicExchange exchange(){
        return new TopicExchange(RabbitMqConstant.EXCHANGE_TOPIC_MANORWOMAN);
    }

    /**
     * 将manQueue队列和TopicExchange进行绑定，而且指定的键值为topic.man
     * 这样只要是消息携带的路由键是topic.man 才会分发到该队列中
     * @return
     */
    @Bean
    Binding bindingExchangeMan(){
        return BindingBuilder.bind(manQueue()).to(exchange()).with(RabbitMqConstant.EXCHANGE_BINDING_MAN_RULE);
    }

    /**
     * 将womanQueue队列和TopicExchange进行绑定，而且指定的键值为topic.#
     * 这样只要是消息携带的路由键是以topic.开头,都会分发到该队列
     * @return
     */
    @Bean
    Binding bindingExchangeWoman(){
        return BindingBuilder.bind(womanQueue()).to(exchange()).with(RabbitMqConstant.EXCHANGE_BINDING_WOMAN_RULE);
    }

}
