package com.example.ChatBox.config;

//This configures websocket endpoint and message broker

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.*;

// @EnableWebSocketMessageBroker is used to enable the WebSocket server
// Implement the WebSocketMessageBrokerConfigurer interface and provide ... 
// implementation for some of its methods to configure a connection

@Configuration
@EnableWebSocketMessageBroker
public class ChatBoxConfig implements WebSocketMessageBrokerConfigurer {
	
	// Register a websocket endpoint that the clients use to connect to the websocket server
	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		registry.addEndpoint("/ws").withSockJS(); //SockJS is used to enable fallback options for browsers that dont support websocket
	}
	
	@Override
	public void configureMessageBroker(MessageBrokerRegistry registry) {
		registry.setApplicationDestinationPrefixes("/app");
		registry.enableSimpleBroker("/topic");
		
	}
}
