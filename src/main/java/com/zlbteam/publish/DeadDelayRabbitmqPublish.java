package com.zlbteam.publish;

import com.zlbteam.constant.DeadDelayRabbitMqConstant;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

@Service
public class DeadDelayRabbitmqPublish {

    private static final long DELAY_TIME = 5000L;

    @Resource
    private AmqpTemplate amqpTemplate;

    /**
     * 发布直连消息-路由方式
     */
    public void direct1Send(Map<String, String> msg){
        //给延迟队列发送消息
        amqpTemplate.convertAndSend(DeadDelayRabbitMqConstant.DIRECT1_EXCHANGE, DeadDelayRabbitMqConstant.DIRECT1_TTL_ROUTING, msg, new MessagePostProcessor() {
            @Override
            public Message postProcessMessage(Message message) {
                //给消息设置延迟毫秒值
                message.getMessageProperties().setExpiration(String.valueOf(DELAY_TIME));
                return message;
            }
        });
    }

    /**
     * 发布直连消息
     */
    public void directSend(Map<String, String> msg){
        //给延迟队列发送消息
        amqpTemplate.convertAndSend(DeadDelayRabbitMqConstant.DIRECT_TTL_EXCHANGE, DeadDelayRabbitMqConstant.DIRECT_TTL_ROUTING, msg, new MessagePostProcessor() {
            @Override
            public Message postProcessMessage(Message message) throws AmqpException {
                //给消息设置延迟毫秒值
                message.getMessageProperties().setExpiration(String.valueOf(DELAY_TIME));
                return message;
            }
        });
    }

    /**
     * 发布广播消息
     */
    public void fanoutSend(Map<String, String> msg){
        //给延迟队列发送消息
        amqpTemplate.convertAndSend(DeadDelayRabbitMqConstant.FANOUT_TTL_EXCHANGE, null, msg, new MessagePostProcessor() {
            @Override
            public Message postProcessMessage(Message message) throws AmqpException {
                //给消息设置延迟毫秒值
                message.getMessageProperties().setExpiration(String.valueOf(DELAY_TIME));
                return message;
            }
        });
    }

    /**
     * 发布主题消息
     */
    public void topicSend(Map<String, String> msg){
        //给延迟队列发送消息
        amqpTemplate.convertAndSend(DeadDelayRabbitMqConstant.TOPIC_EXCHANGE, DeadDelayRabbitMqConstant.TOPIC_TTL_ROUTING, msg, new MessagePostProcessor() {
            @Override
            public Message postProcessMessage(Message message) throws AmqpException {
                //给消息设置延迟毫秒值
                message.getMessageProperties().setExpiration(String.valueOf(DELAY_TIME));
                return message;
            }
        });
    }
}
