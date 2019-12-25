package com.wzx.streammq.controller;

import com.alibaba.fastjson.JSON;
import com.wzx.streammq.dto.EcifCardVo;
import com.wzx.streammq.dto.OrderDTO;
import com.wzx.streammq.dto.OrderListDTO;
import com.wzx.streammq.mq.ArtisanSink;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@Slf4j
public class SendMQController {

    @Autowired
    private ArtisanSink sink;

    @Autowired
    private AmqpTemplate amqpTemplate;

    /**
     * 自定义消息队列
     * @param msg
     */
    @GetMapping("sendMsg/{msg}")
    public void sendMsgByStream(@PathVariable("msg") String msg){
        log.info("SendMQController.sendMsgByStream发送消息参数:{}",msg);
        Message<String> build = MessageBuilder.withPayload(msg).build();
        log.info("build:{}",build);
        for(int i =0 ;i<10;i++){
            String sendMsg =  msg+"++++"+i;
            sink.input().send(MessageBuilder.withPayload(sendMsg).build());
        }
    }

    /**
     * 普通队列
     * @param msg
     */
    @GetMapping("sendHello/{msg}")
    public void sendHello(@PathVariable("msg") String msg) {
        log.info("SendMQController.sendHello:{}",msg);
        Message<String> build = MessageBuilder.withPayload(msg).build();
        log.info("build:{}",build);
        for(int i =0 ;i<10;i++){
            String sendMsg =  msg+"++++"+i;
            amqpTemplate.convertAndSend("send_hello",sendMsg);
        }

    }

    /**
     * 使用Topic交换机-根据routing_key发送-队列
     * @param msg
     */
    @GetMapping("sendTopicMsg/{msg}")
    public void sendTopicMsg(@PathVariable("msg") String msg) {
        log.info("SendMQController.sendTopicMsg:{}",msg);
        amqpTemplate.convertAndSend("myExchange","topic.message",msg);
    }

    @GetMapping("sendTopicMsg2/{msg}")
    public void sendTopicMsg2(@PathVariable("msg") String msg) {
        log.info("SendMQController.sendTopicMsg2:{}",msg);
        amqpTemplate.convertAndSend("myExchange","topic.123",msg);
    }

    /**
     * 自定义队列 传参(对象)
     */
    @GetMapping("/sendMsgToObject")
    public void sendMsgToObject(){

        OrderListDTO orderListDTO = new OrderListDTO();
        orderListDTO.setId("1");
        orderListDTO.setDesc("我是对象中包含集合");
        List<OrderDTO> orderDTOList = new ArrayList<>();
        for (int i = 0;i<1000;i++){
            OrderDTO orderDTO = new OrderDTO();
            orderDTO.setOrderId(String.valueOf(i));
            orderDTO.setOrderAmount(new BigDecimal(9999));
            orderDTOList.add(orderDTO);
        }
        orderListDTO.setOrderDTOList(orderDTOList);
        log.info("SendMQController.sendMsgToObject发送参数为:{}",orderListDTO);
        sink.input().send(MessageBuilder.withPayload(JSON.toJSONString(orderListDTO)).build());
    }

    /**
     * 使用Fanout交换机-队列
     * @param msg
     */
    @GetMapping("sendFanout/{msg}")
    public void sendFanout(@PathVariable("msg") String msg) {
        log.info("SendMQController.sendFanout:{}",msg);
        amqpTemplate.convertAndSend("myFanoutExchange","",msg);
    }

    @PostMapping("sendEcif")
    public void sendEcifMsg(@RequestBody EcifCardVo ecifCardVo){
        if(Objects.isNull(ecifCardVo)){
            log.info("接受参数为空");
        }
        log.info("参数为：{}",ecifCardVo);
        sink.ecifInput().send(MessageBuilder.withPayload(JSON.toJSONString(ecifCardVo)).build());
    }


}
