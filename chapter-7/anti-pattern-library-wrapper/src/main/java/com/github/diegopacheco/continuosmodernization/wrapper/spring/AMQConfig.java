package com.github.diegopacheco.continuosmodernization.wrapper.spring;

import com.github.diegopacheco.continuosmodernization.wrapper.AMQClient;
import com.github.diegopacheco.continuosmodernization.wrapper.impl.AMQImpl;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AMQConfig {

    public AMQClient getAMQClient(){
        return new AMQImpl();
    }
}
