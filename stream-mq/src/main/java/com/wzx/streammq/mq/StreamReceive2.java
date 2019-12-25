package com.wzx.streammq.mq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Slf4j
@EnableBinding(ArtisanSink.class)   //注解 绑定刚才的接口
@Component
public class StreamReceive2 {


    // @StreamListener 绑定对象的名称(监听通道名称)
    @StreamListener(ArtisanSink.OUTPUT)
    public void processStreamMsg(String msg){
        log.info("StreamReceive2222222.processStreamMsg监听到信息: {}",msg);
    }

    @StreamListener(ArtisanSink.ECIFOUTPUT)
    public void ecifMsgReceive(String map){
        log.info("StreamReceive2222222.ecifMsgReceive: {}",map);
    }
}
