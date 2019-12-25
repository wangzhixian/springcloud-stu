package com.wzx.eurekaclientconsumer.controller;

import com.wzx.eurekaclientconsumer.feign.HelloRemote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class ConsumerController {

    @Value("${wzx.name}")
    private String name;

    @Autowired
    HelloRemote helloRemote;

    @RequestMapping("/hello/{name}")
    public String index(@PathVariable("name")String name){
        return  helloRemote.index(name);
    }

    @RequestMapping("/say/config")
    public String sagToConfig(){
        return "你好,"+this.name ;
    }

}
