package com.xiaoai.rabbitmq.provider.queue;

import com.xiaoai.rabbitmq.provider.constant.RabbitMqConstant;
import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ailiqiang
 * @date 2020/9/18
 * @desc 直连交换机 Order 配置类
*/
@Configuration
public class DirectOrderQueuqConfig {

  /**
   * 定义队列
   * 注：durable:是否持久化,默认是false,持久化队列：会被存储在磁盘上，当消息代理重启时仍然存在，暂存队列：当前连接有效
   * 注：exclusive:默认也是false，只能被当前创建的连接使用，而且当连接关闭后队列即被删除。此参考优先级高于durable
   * 注：autoDelete:是否自动删除，当没有生产者或者消费者使用此队列，该队列会自动删除
   * @return
   */
  @Bean("orderQueue")
  public Queue orderQueue(){

   return new Queue(RabbitMqConstant.QUEUE_DIRECT_ORDER,true);
  }

  /**
   * 定义交换机
   * @return
   */
  @Bean("orderDirectExchange")
  DirectExchange orderDirectExchange(){
    return new DirectExchange(RabbitMqConstant.EXCHANGE_DIRECT_ORDER,true,false);
  }

  /**
   * 交换机 队列 进行绑定
   * @param queue
   * @param exchange
   * @return
   */
  @Bean
  Binding bindingOrderDirect(@Qualifier("orderQueue") Queue queue,@Qualifier("orderDirectExchange")
      Exchange exchange){
    return BindingBuilder.bind(queue).to(exchange).with(RabbitMqConstant.EXCHANGE_BINDING_ORDER_RULE).noargs();
  }
}
