package com.wzx.eurekaclient.controller;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @RequestMapping("/hello")
    public String index(@RequestParam String name){
        return  "hello,"+name+",this is first message";
    }



    /**
     * 自定义消息队列
     * @param msg
     */
    @GetMapping("sendMsg/{msg}")
    public void sendMsgByStream(@PathVariable("msg") String msg){
        System.out.println("接受到msg:"+msg);
        for(int i =0 ;i<10;i++){
            String sendMsg =  msg+"++++"+i;
            amqpTemplate.convertAndSend("myExchange","topic.123",sendMsg);
        }
    }
}
