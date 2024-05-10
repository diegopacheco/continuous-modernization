package com.github.antipatterns.continuous.modernization.wrapper;

public interface AMQClient {
    public AMQClient init();
    public void send(String message,String channel);
}
