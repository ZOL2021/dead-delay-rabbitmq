package com.zlbteam.controller;

import com.zlbteam.publish.DeadDelayRabbitmqPublish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class DeadDelayRabbitmqController {

    @Autowired
    DeadDelayRabbitmqPublish delayRabbitmqPublish;

    @RequestMapping("/direct1")
    public String direct1(){
        Map<String, String> map = new HashMap<>(16);
        map.put("msg", "direct1");
        delayRabbitmqPublish.direct1Send(map);
        return "direct1";
    }

    @RequestMapping("/direct")
    public String direct(){
        Map<String, String> map = new HashMap<>(16);
        map.put("msg", "direct");
        delayRabbitmqPublish.directSend(map);
        return "direct";
    }

    @RequestMapping("/fanout")
    public String fanout(){
        Map<String, String> map = new HashMap<>(16);
        map.put("msg", "fanout");
        delayRabbitmqPublish.fanoutSend(map);
        return "fanout";
    }

    @RequestMapping("/topic")
    public String topic(){
        Map<String, String> map = new HashMap<>(16);
        map.put("msg", "topic");
        delayRabbitmqPublish.topicSend(map);
        return "topic";
    }
}
