package com.wzx.streammq.receive;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Configuration;

@Configuration
@RabbitListener(queues = "topic_message_2")
@Slf4j
public class TopicReceive2 {

    @RabbitHandler
    public void process(String msg){
        log.info("TopicReceive22222.process消费：{}",msg);
    }
}
