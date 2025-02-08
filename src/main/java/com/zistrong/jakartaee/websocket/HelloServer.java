package com.zistrong.jakartaee.websocket;

import jakarta.websocket.ClientEndpoint;
import jakarta.websocket.OnMessage;
import jakarta.websocket.Session;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@ClientEndpoint(subprotocols = "chat")
public class HelloServer {

    private static final Logger LOGGER = LogManager.getLogger(HelloServer.class);


    @OnMessage
    public void processMessageFromServer(String message, Session session) {
        LOGGER.info("Message came from the server ! {}", message);
    }
}
