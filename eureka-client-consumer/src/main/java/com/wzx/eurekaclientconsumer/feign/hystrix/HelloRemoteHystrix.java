package com.wzx.eurekaclientconsumer.feign.hystrix;

import com.wzx.eurekaclientconsumer.feign.HelloRemote;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

@Component
public class HelloRemoteHystrix implements HelloRemote {

    @Override
    public String index(@PathVariable(value = "name") String name) {
        return "hystrix,"+name+", this is massage send failed";
    }
}
