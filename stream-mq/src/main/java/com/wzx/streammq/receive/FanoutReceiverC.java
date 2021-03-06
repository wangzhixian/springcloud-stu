package com.wzx.streammq.receive;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RabbitListener(queues = "q_fanout_C")
public class FanoutReceiverC {

    @RabbitHandler
    public void process(String msg){
        log.info("FanoutReceiverCCCCC.process消费:{}",msg);
    }
}
