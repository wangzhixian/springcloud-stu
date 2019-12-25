package com.wzx.streammq.mq;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * 自定义一个消息通道   MyMsgInput
 */
public interface ArtisanSink {

    /**
     * 同一个服务里面的通道名字不能一样，在不同的服务里可以相同名字的通道
     * 否则启动抛出如下异常  bean definition with this name already exists
     */
    String INPUT = "MyMsgInput";
    String OUTPUT = "MyMsgOutput";

    /**
     * @Input注解的参数则表示了消息通道的名称
     * @return
     */
    @Input(ArtisanSink.INPUT)
    SubscribableChannel input();

    @Output(ArtisanSink.OUTPUT)
    MessageChannel output();


    String ECIFINPUT = "EcifInput";
    String ECIFOUTPUT = "EcifOutput";

    @Input(ArtisanSink.ECIFINPUT)
    SubscribableChannel ecifInput();

    @Output(ArtisanSink.ECIFOUTPUT)
    MessageChannel ecifOutput();
}
