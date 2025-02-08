package com.zistrong.jakartaee.websocket;


import jakarta.websocket.*;
import jakarta.websocket.server.PathParam;
import jakarta.websocket.server.ServerEndpoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@ServerEndpoint("/chatroom/{roomId}")
public class ChatRoom {
    private final Logger logger = LoggerFactory.getLogger(ChatRoom.class);

    private final static Map<String, Session> sessionMap = new ConcurrentHashMap<>();

    @OnOpen
    public void onOpen(Session session, @PathParam("roomId") String roomId) {
        logger.info(roomId);
        sessionMap.putIfAbsent(roomId, session);
    }

    @OnMessage
    public void onMessage(Session session, String message, @PathParam("roomId") String roomId) {

        sessionMap.forEach((k, v) -> {
            if(!k.endsWith(roomId)) {
                try {
                    v.getBasicRemote().sendText("hello,message, I'm " + message);
                } catch (IOException e) {
                    logger.error(e.getMessage(), e);
                }
            }
        });
    }

    @OnClose
    public void onClose(Session session, @PathParam("roomId") String roomId) throws IOException {

        logger.info("close ="+roomId);
        session.close();
        sessionMap.remove(roomId);
    }

    @OnError
    public void onError(Session session, Throwable error) {
        error.printStackTrace();
    }


}

