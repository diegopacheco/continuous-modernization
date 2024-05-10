package com.github.diegopacheco.continuosmodernization.wrapper;

public interface AMQClient {
    public void send(String message,String channel);
}
