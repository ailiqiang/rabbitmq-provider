package com.xiaoai.rabbitmq.provider.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author ailiqiang
 * @date 2020/9/15
 * @desc Topic队列生产者消息发送controller类
*/
@RestController
public class TopicController {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @GetMapping("/topic1")
    public String sendTopicMessage(){

        String messageId = String.valueOf(UUID.randomUUID());
        String messageData = "test message, hello 111";
        String createTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        Map<String,Object> map = new HashMap<>();
        map.put("messageId",messageId);
        map.put("messageData",messageData);
        map.put("createTime",createTime);

        //将消息以topic模式发送到队列中 绑定键：topic.man 交换机：TopicExchange
        rabbitTemplate.convertAndSend("TopicExchange","topic.man",map);
        return "OK";
    }

    @GetMapping("/topic2")
    public String sendTopicMessage2(){

        String messageId = String.valueOf(UUID.randomUUID());
        String messageData = "test message, hello 222";
        String createTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        Map<String,Object> map = new HashMap<>();
        map.put("messageId",messageId);
        map.put("messageData",messageData);
        map.put("createTime",createTime);

        //将消息以topic模式发送到队列中 绑定键：topic.man 交换机：TopicExchange
        rabbitTemplate.convertAndSend("TopicExchange","topic.woman",map);
        return "OK";
    }
}
