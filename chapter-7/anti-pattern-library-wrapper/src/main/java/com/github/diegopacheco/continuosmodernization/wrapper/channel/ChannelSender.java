package com.github.diegopacheco.continuosmodernization.wrapper.channel;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

public class ChannelSender {

    private Connection conn;
    private Channel channel;

    public void send(Connection conn,Channel channel,MessageCallback cb){
        doWork(conn,channel,cb);
    }

    private void doWork(Connection conn,Channel channel,MessageCallback cb){
        cb.prepare(conn,channel);
    }

}
