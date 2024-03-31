package com.example.demo.config;


import com.corundumstudio.socketio.SocketIOServer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

public class SocketConfig {

    @Bean
    public SocketIOServer socketIoServer () {
        com.corundumstudio.socketio.Configuration config = new com.corundumstudio.socketio.Configuration();
        config.setPort(9092);
        return new SocketIOServer(config);
    }

}
