package com.github.antipatterns.continuous.modernization.wrapper.spring;

import com.github.antipatterns.continuous.modernization.wrapper.AMQClient;
import com.github.antipatterns.continuous.modernization.wrapper.impl.AMQImpl;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AMQConfig {

    public AMQClient getAMQClient(){
        return new AMQImpl();
    }

}
