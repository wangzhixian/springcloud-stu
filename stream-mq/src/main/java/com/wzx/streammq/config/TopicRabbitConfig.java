package com.wzx.streammq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TopicRabbitConfig {

    final static String message1 = "topic_message_1";
    final static String message2 = "topic_message_2";

    @Bean
    public Queue queueMessage1(){
        return new Queue(TopicRabbitConfig.message1);
    }

    @Bean
    public Queue queueMessage2(){
        return new Queue(TopicRabbitConfig.message2);
    }

    /**
     * 声明一个Topic类型的交换机
     * @return
     */
    @Bean
    TopicExchange exchange(){
        return new TopicExchange("myExchange");
    }

    /**
     * 绑定Q到交换机，并且指定routingKey
     * @param queueMessage1
     * @param exchange
     * @return
     */
    @Bean
    Binding bindingExchangeMessage(Queue queueMessage1,TopicExchange exchange){
        return BindingBuilder.bind(queueMessage1).to(exchange).with("topic.message");
    }

    @Bean
    Binding bindingExchangeMessages(Queue queueMessage2, TopicExchange exchange) {
        return BindingBuilder.bind(queueMessage2).to(exchange).with("topic.#");
    }

}
