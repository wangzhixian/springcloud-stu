package com.wzx.common.mq;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.stereotype.Component;

@Component
public interface ArtisanSink2 {

    /**
     * 同一个服务里面的通道名字不能一样，在不同的服务里可以相同名字的通道
     * 否则启动抛出如下异常  bean definition with this name already exists
     */
    String INPUT = "msgInput";
    String OUTPUT = "msgOutput";

    /**
     * @Input注解的参数则表示了消息通道的名称
     * @return
     */
    @Input(ArtisanSink2.INPUT)
    SubscribableChannel input();

    @Output(ArtisanSink2.OUTPUT)
    MessageChannel output();
}
