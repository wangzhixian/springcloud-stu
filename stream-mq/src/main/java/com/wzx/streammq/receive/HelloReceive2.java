package com.wzx.streammq.receive;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "send_hello")
@Slf4j
public class HelloReceive2 {

    @RabbitHandler
    public void process(String msg){
      log.info("HelloReceive2222.process消费:{}",msg);

    }
}
