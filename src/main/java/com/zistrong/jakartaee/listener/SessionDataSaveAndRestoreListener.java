package com.zistrong.jakartaee.listener;

import jakarta.faces.event.*;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@WebListener
public class SessionDataSaveAndRestoreListener implements HttpSessionListener, SystemEventListener, ServletContextListener {


    private static final Logger LOGGER = LogManager.getLogger(SessionDataSaveAndRestoreListener.class);

    @Override
    public void processEvent(SystemEvent systemEvent) throws AbortProcessingException {
        if (systemEvent instanceof PostConstructApplicationEvent) {
        } else if (systemEvent instanceof PreDestroyApplicationEvent) {
        } else if (systemEvent instanceof PostValidateEvent) {
        }
    }

    @Override
    public boolean isListenerForSource(Object source) {
        return true;
    }

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        LOGGER.info("sessionCreated: {}", httpSessionEvent.getSession().getId());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        LOGGER.info("sessionDestroyed: {}", httpSessionEvent.getSession().getId());
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {


    }
}
