package com.github.diegopacheco.continuosmodernization.wrapper.impl;

import com.github.diegopacheco.continuosmodernization.wrapper.AMQClient;
import com.github.diegopacheco.continuosmodernization.wrapper.utils.Channels;
import com.github.diegopacheco.continuosmodernization.wrapper.utils.RoutingKeys;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * This code was created as (bad) example of anti-pattern: Internal Shared Library Wrappers.
 * All the bad decisions here are done by design to demonstrate bade decisions and antimatter.
 * This is not a code example to be copied or even followed, this is how you not do it.
 */
public class AMQImpl implements AMQClient {

    @Override
    public void send(String message, String channelName) {
        try{
            // Boilerplate code that is removed from the engineer.
            //Hard coded host for developer commodity :D
            ConnectionFactory factory = new ConnectionFactory();

            String aws = System.getenv("IS_RUNNING_ON_AWS");
            if (aws != null) {
                factory.setUsername("hardcodeduser");
                factory.setPassword("hardcoded-pass");
                factory.setHost("a-c8352325-ec90-4578-ad8c-a43f13d325aa.mq.us-west-2.amazonaws.com");
                factory.setPort(5671);
                // Allows client to establish a connection over TLS
                factory.useSslProtocol();
            }else{
                factory.setUsername("guest");
                factory.setPassword("guest");
                factory.setHost("127.0.0.1");
                factory.setPort(5672);
            }

            // Create a connection
            Connection conn = factory.newConnection();

            // Create a channel
            Channel channel = conn.createChannel();

            byte[] messageBodyBytes = "Hello, world!".getBytes();
            channel.basicPublish(String.valueOf(Channels.DEFAULT_CHANNEL), RoutingKeys.KEY,
                    new AMQP.BasicProperties.Builder()
                            .contentType("text/plain")
                            .userId("DEFAULT_KEY")
                            .build(),
                    messageBodyBytes);

            channel.close();
            conn.close();

        }catch(Exception e){
            // swallow exception
            e.printStackTrace();
        }
    }
}
