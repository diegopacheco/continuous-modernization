package com.github.diegopacheco.continuosmodernization.wrapper.channel;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

public interface MessageCallback {

    public void prepare(Connection conn, Channel channel);
}
