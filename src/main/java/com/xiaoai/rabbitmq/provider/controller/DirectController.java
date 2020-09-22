package com.xiaoai.rabbitmq.provider.controller;

import com.xiaoai.rabbitmq.provider.constant.RabbitMqConstant;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author ailiqiang
 * @date 2020/9/15
 * @desc Direct队列生产者消息发送controller类
*/
@RestController
public class DirectController {

    @Resource(name = "")
    RabbitTemplate rabbitTemplate;

    @Resource(name = "rabbitDelayTemplate")
    RabbitTemplate rabbitDelayTemplate;

    @GetMapping("/direct")
    public String sendDirectMessage(){

        String messageId = String.valueOf(UUID.randomUUID());
        String messageData = "test message, hello";
        String createTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        Map<String,Object> map = new HashMap<>();
        map.put("messageId",messageId);
        map.put("messageData",messageData);
        map.put("createTime",createTime);

        //将消息以Direct模式发送到队列中 绑定键：TestDirectRouting 交换机：TestDirectExchange
        rabbitTemplate.convertAndSend("TestDirectExchange","TestDirectRouting",map);
        return "OK";
    }


    @GetMapping("/delay")
    public String delay() throws InterruptedException {

        String messageId = String.valueOf(UUID.randomUUID());
        String messageData = "test message, hello";
        String createTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        Map<String,Object> map = new HashMap<>();
        map.put("messageId",messageId);
        map.put("messageData",messageData);
        map.put("createTime",createTime);

        rabbitDelayTemplate.convertAndSend(RabbitMqConstant.EXCHANGE_DELAY_PROCESS, RabbitMqConstant.EXCHANGE_BINDING_PROCESS_RULE,map, message -> {
            message.getMessageProperties().setDelay(10000);
            return message;
        }
        );
        return "OK";
    }
}
