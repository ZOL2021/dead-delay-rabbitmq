package com.zlbteam.constant;

public class DeadDelayRabbitMqConstant {
    /**
     * 公共前缀
     */
    public static final String DEAD_DELAY = "dead.delay.";
    public static final String TTL = "ttl.";
    public static final String EXCHANGE = "exchange";
    public static final String QUEUE = "queue";
    public static final String ROUTING = "routing";
    public static final String SECOND = "second.";
    public static final String THIRD = "third.";

    /**
     * 直连
     */
    public static final String DIRECT = "direct.";
    public static final String DIRECT_EXCHANGE = DEAD_DELAY + DIRECT + EXCHANGE;
    public static final String DIRECT_TTL_EXCHANGE = DEAD_DELAY + DIRECT + TTL + EXCHANGE;
    public static final String DIRECT_QUEUE = DEAD_DELAY + DIRECT + QUEUE;
    public static final String DIRECT_TTL_QUEUE = DEAD_DELAY + DIRECT + TTL + QUEUE;
    public static final String DIRECT_ROUTING = DEAD_DELAY + DIRECT + ROUTING;
    public static final String DIRECT_TTL_ROUTING = DEAD_DELAY + DIRECT + TTL + ROUTING;

    /**
     * 直连-路由方式
     */
    public static final String DIRECT1 = "direct1.";
    public static final String DIRECT1_EXCHANGE = DEAD_DELAY + DIRECT1 + EXCHANGE;
    public static final String DIRECT1_QUEUE = DEAD_DELAY + DIRECT1 + QUEUE;
    public static final String DIRECT1_TTL_QUEUE = DEAD_DELAY + DIRECT1 + TTL + QUEUE;
    public static final String DIRECT1_ROUTING = DEAD_DELAY + DIRECT1 + ROUTING;
    public static final String DIRECT1_TTL_ROUTING = DEAD_DELAY + DIRECT1 + TTL + ROUTING;

    /**
     * 广播
     */
    public static final String FANOUT = "fanout.";
    public static final String FANOUT_EXCHANGE = DEAD_DELAY + FANOUT + EXCHANGE;
    public static final String FANOUT_TTL_EXCHANGE = DEAD_DELAY + FANOUT + TTL + EXCHANGE;
    public static final String FANOUT_QUEUE = DEAD_DELAY + FANOUT + QUEUE;
    public static final String FANOUT_SECOND_QUEUE = DEAD_DELAY + FANOUT + SECOND +QUEUE;
    public static final String FANOUT_TTL_QUEUE = DEAD_DELAY + FANOUT + TTL + QUEUE;
    public static final String FANOUT_ROUTING = DEAD_DELAY + FANOUT + ROUTING;

    /**
     * 主题-略
     */

    /**
     * 主题-路由方式
     */
    public static final String TOPIC = "topic.";
    public static final String TOPIC_EXCHANGE = DEAD_DELAY + TOPIC + EXCHANGE;
    public static final String TOPIC_QUEUE = DEAD_DELAY + TOPIC + QUEUE;
    public static final String TOPIC_TTL_QUEUE = DEAD_DELAY + TOPIC + TTL + QUEUE;
    public static final String TOPIC_ROUTING = DEAD_DELAY + TOPIC + ROUTING;
    public static final String TOPIC_TTL_ROUTING = DEAD_DELAY + TOPIC + TTL + ROUTING;

}
