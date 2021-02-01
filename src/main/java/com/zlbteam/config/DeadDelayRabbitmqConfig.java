package com.zlbteam.config;

import com.zlbteam.constant.DeadDelayRabbitMqConstant;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class DeadDelayRabbitmqConfig {

    private static final String X_DEAD_LETTER_EXCHANGE = "x-dead-letter-exchange";
    private static final String X_DEAD_LETTER_ROUTING_KEY = "x-dead-letter-routing-key";

    /**
     * 直连
     */
    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange(DeadDelayRabbitMqConstant.DIRECT_EXCHANGE);
    }

    @Bean
    public DirectExchange directTtlExchange() {
        return new DirectExchange(DeadDelayRabbitMqConstant.DIRECT_TTL_EXCHANGE);
    }

    @Bean
    public Queue directQueue() {
        return new Queue(DeadDelayRabbitMqConstant.DIRECT_QUEUE);
    }

    @Bean
    public Queue directTtlQueue() {
        Map<String, Object> map = new HashMap<>(16);
        map.put(X_DEAD_LETTER_EXCHANGE, DeadDelayRabbitMqConstant.DIRECT_EXCHANGE);
        map.put(X_DEAD_LETTER_ROUTING_KEY, DeadDelayRabbitMqConstant.DIRECT_ROUTING);
        return new Queue(DeadDelayRabbitMqConstant.DIRECT_TTL_QUEUE, true, false, false, map);
    }

    @Bean
    public Binding directBinding(Queue directQueue, DirectExchange directExchange) {
        return BindingBuilder
                .bind(directQueue)
                .to(directExchange)
                .with(DeadDelayRabbitMqConstant.DIRECT_ROUTING);
    }

    @Bean
    public Binding directTtlBinding(Queue directTtlQueue, DirectExchange directTtlExchange) {
        return BindingBuilder
                .bind(directTtlQueue)
                .to(directTtlExchange)
                .with(DeadDelayRabbitMqConstant.DIRECT_TTL_ROUTING);
    }

    /**
     * 直连-路由方式
     */
    @Bean
    public DirectExchange direct1Exchange() {
        return new DirectExchange(DeadDelayRabbitMqConstant.DIRECT1_EXCHANGE);
    }
    @Bean
    public Queue direct1Queue() {
        return new Queue(DeadDelayRabbitMqConstant.DIRECT1_QUEUE);
    }

    @Bean
    public Queue direct1TtlQueue() {
        Map<String, Object> map = new HashMap<>(16);
        map.put(X_DEAD_LETTER_EXCHANGE, DeadDelayRabbitMqConstant.DIRECT1_EXCHANGE);
        map.put(X_DEAD_LETTER_ROUTING_KEY, DeadDelayRabbitMqConstant.DIRECT1_ROUTING);
        return new Queue(DeadDelayRabbitMqConstant.DIRECT1_TTL_QUEUE, true, false, false, map);
    }

    @Bean
    public Binding direct1Binding(Queue direct1Queue, DirectExchange direct1Exchange) {
        return BindingBuilder
                .bind(direct1Queue)
                .to(direct1Exchange)
                .with(DeadDelayRabbitMqConstant.DIRECT1_ROUTING);
    }

    @Bean
    public Binding direct1TtlBinding(Queue direct1TtlQueue, DirectExchange direct1Exchange) {
        return BindingBuilder
                .bind(direct1TtlQueue)
                .to(direct1Exchange)
                .with(DeadDelayRabbitMqConstant.DIRECT1_TTL_ROUTING);
    }


    /**
     * 广播
     */
    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange(DeadDelayRabbitMqConstant.FANOUT_EXCHANGE);
    }

    @Bean
    public FanoutExchange fanoutTtlExchange() {
        return new FanoutExchange(DeadDelayRabbitMqConstant.FANOUT_TTL_EXCHANGE);
    }

    @Bean
    public Queue fanoutQueue() {
        return new Queue(DeadDelayRabbitMqConstant.FANOUT_QUEUE);
    }

    @Bean
    public Queue fanoutSecondQueue() {
        return new Queue(DeadDelayRabbitMqConstant.FANOUT_SECOND_QUEUE);
    }

    @Bean
    public Queue fanoutTtlQueue() {
        Map<String, Object> map = new HashMap<>(16);
        map.put(X_DEAD_LETTER_EXCHANGE, DeadDelayRabbitMqConstant.FANOUT_EXCHANGE);
        map.put(X_DEAD_LETTER_ROUTING_KEY, DeadDelayRabbitMqConstant.FANOUT_ROUTING);
        return new Queue(DeadDelayRabbitMqConstant.FANOUT_TTL_QUEUE, true, false, false, map);
    }

    @Bean
    public Binding fanoutBinding(Queue fanoutQueue, FanoutExchange fanoutExchange) {
        return BindingBuilder
                .bind(fanoutQueue)
                .to(fanoutExchange);
    }

    @Bean
    public Binding fanoutSecondBinding(Queue fanoutSecondQueue, FanoutExchange fanoutExchange) {
        return BindingBuilder
                .bind(fanoutSecondQueue)
                .to(fanoutExchange);
    }

    @Bean
    public Binding fanoutTtlBinding(Queue fanoutTtlQueue, FanoutExchange fanoutTtlExchange) {
        return BindingBuilder
                .bind(fanoutTtlQueue)
                .to(fanoutTtlExchange);
    }

    /**
     * 主题-交换机方式 - 略
     */

    /**
     * 主题-路由方式
     */

    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange(DeadDelayRabbitMqConstant.TOPIC_EXCHANGE);
    }

    @Bean
    public Queue topicQueue() {
        return new Queue(DeadDelayRabbitMqConstant.TOPIC_QUEUE);
    }

    @Bean
    public Queue topicTtlQueue() {
        Map<String, Object> map = new HashMap<>(16);
        map.put(X_DEAD_LETTER_EXCHANGE, DeadDelayRabbitMqConstant.TOPIC_EXCHANGE);
        map.put(X_DEAD_LETTER_ROUTING_KEY, DeadDelayRabbitMqConstant.TOPIC_ROUTING);
        return new Queue(DeadDelayRabbitMqConstant.TOPIC_TTL_QUEUE, true, false, false, map);
    }

    @Bean
    public Binding topicBinding(Queue topicQueue, TopicExchange topicExchange) {
        return BindingBuilder
                .bind(topicQueue)
                .to(topicExchange)
                .with(DeadDelayRabbitMqConstant.TOPIC_ROUTING);
    }

    @Bean
    public Binding topicTtlBinding(Queue topicTtlQueue, TopicExchange topicExchange) {
        return BindingBuilder
                .bind(topicTtlQueue)
                .to(topicExchange)
                .with(DeadDelayRabbitMqConstant.TOPIC_TTL_ROUTING);
    }

}
