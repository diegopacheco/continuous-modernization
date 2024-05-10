package com.github.diegopacheco.continuosmodernization.wrapper;

public interface AMQClient {
    public AMQClient init();
    public void send(String message,String channel);
}
