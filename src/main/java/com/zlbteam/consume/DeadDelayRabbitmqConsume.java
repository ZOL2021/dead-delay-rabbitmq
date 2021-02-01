package com.zlbteam.consume;

import com.zlbteam.constant.DeadDelayRabbitMqConstant;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class DeadDelayRabbitmqConsume {

    /**
     * direct
     */

    @RabbitListener(queues = DeadDelayRabbitMqConstant.DIRECT1_QUEUE)
    public void direct1Consume(Map<String, String> map) {
        String msg = map.get("msg");
        System.out.println(msg);
    }

    @RabbitListener(queues = DeadDelayRabbitMqConstant.DIRECT_QUEUE)
    public void directConsume(Map<String, String> map) {
        String msg = map.get("msg");
        System.out.println(msg);
    }

    /**
     * fanout
     */

    @RabbitListener(queues = DeadDelayRabbitMqConstant.FANOUT_QUEUE)
    public void fanoutConsume(Map<String, String> map) {
        String msg = map.get("msg");
        System.out.println("fanout.first:" + msg);
    }

    @RabbitListener(queues = DeadDelayRabbitMqConstant.FANOUT_SECOND_QUEUE)
    public void fanoutSecondConsume(Map<String, String> map) {
        String msg = map.get("msg");
        System.out.println("fanout.second:" + msg);
    }

    /**
     * topic
     */

    @RabbitListener(queues = DeadDelayRabbitMqConstant.TOPIC_QUEUE)
    public void topicConsume(Map<String, String> map) {
        String msg = map.get("msg");
        System.out.println("topic:" + msg);
    }
}
