package com.wzx.eurekaclientconsumer.feign;

import com.wzx.eurekaclientconsumer.feign.hystrix.HelloRemoteHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="eureka-client-producer",fallback = HelloRemoteHystrix.class)
public interface HelloRemote {
    @RequestMapping(value = "/hello")
    public String index(@RequestParam(value = "name") String name);
}
