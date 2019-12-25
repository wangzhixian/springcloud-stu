package com.wzx.streammq.receive;

import com.wzx.common.mq.ArtisanSink2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;
@Slf4j
@EnableBinding(ArtisanSink2.class)   //注解 绑定刚才的接口
@Component
public class StrideOverReceiver {

    @StreamListener(ArtisanSink2.INPUT)
    @SendTo(ArtisanSink2.OUTPUT)
    public String ecifReceiveMsg(String msg){
        log.info("我是stream-mq的消费者，接受到参数：{}",msg);
        return "StrideOverReceiver.ecifReceiveMsg：消息已消费";
    }
}
