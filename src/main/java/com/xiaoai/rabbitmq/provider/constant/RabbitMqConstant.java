package com.xiaoai.rabbitmq.provider.constant;

/**
 * @author ailiqiang
 * @date 2020/9/18
 * @desc 全局常量类
*/
public class RabbitMqConstant {

  /** 定义队列名称 **/

  /** Direct 队列定义 **/
  public static final String QUEUE_DIRECT_ORDER = "queue.direct.order";

  /** Fanout 队列定义 **/
  public static final String QUEUE_FANOUT_A = "queue.fanout.a";

  public static final String QUEUE_FANOUT_B = "queue.fanout.b";

  public static final String QUEUE_FANOUT_C = "queue.fanout.c";

  /** Topic 队列定义 **/
  public static final String QUEUE_TOPIC_MAN = "queue.topic.man";

  public static final String QUEUE_TOPIC_WOMAN = "queue.topic.woman";

  /** 定义延时过期处理队列名称 **/
  public static final String QUEUE_DELAY_PROCESS = "queue.delay.process";

  /** 定义交换机名称 **/
  public static final String EXCHANGE_DIRECT_ORDER = "exchange.direct.order";

  public static final String EXCHANGE_FANOUT_ORDERS = "exchange.faount.orders";

  public static final String EXCHANGE_TOPIC_MANORWOMAN = "exchange.topic.manorwoman";

  public static final String EXCHANGE_DELAY_PROCESS = "exchange.delay.process";

  /** DESC *号只能向后多匹配一层路径 **/
  /** DESC #号可以向后匹配多层路径 **/
  /** 交换机绑定规则 **/
  public static final String EXCHANGE_BINDING_ORDER_RULE = "order";

  public static final String EXCHANGE_BINDING_MAN_RULE = "man";

  public static final String EXCHANGE_BINDING_WOMAN_RULE = "man.#";

  public static final String EXCHANGE_BINDING_PROCESS_RULE = "delay_process";
}
