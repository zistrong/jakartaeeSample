package com.zistrong.jakartaee.jms;

import jakarta.annotation.Resource;
import jakarta.ejb.ActivationConfigProperty;
import jakarta.ejb.MessageDriven;
import jakarta.ejb.MessageDrivenContext;
import jakarta.jms.JMSException;
import jakarta.jms.Message;
import jakarta.jms.MessageListener;
import jakarta.jms.TextMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * should create a destination resource named 'jms/sample' in jms resource
 *
 */
@MessageDriven(activationConfig = {
        @ActivationConfigProperty(propertyName = "destinationLookup",
                propertyValue = "jms/sample"),
        @ActivationConfigProperty(propertyName = "destinationType",
                propertyValue = "jakarta.jms.Queue")
})
public class SimpleMessageBean implements MessageListener {

    @Resource
    private MessageDrivenContext mdc;
    static final Logger logger = LoggerFactory.getLogger(SimpleMessageBean.class);


    @Override
    public void onMessage(Message inMessage) {

        logger.info(Thread.currentThread().getName());
        try {
            if (inMessage instanceof TextMessage) {
                logger.info(
                        "MESSAGE BEAN: Message received: {}",
                        inMessage.getBody(String.class));
            } else {
                logger.info(
                        "Message of wrong type: {}",
                        inMessage.getClass().getName());
            }
        } catch (JMSException e) {
            logger.error(
                    "SimpleMessageBean.onMessage: JMSException: {}",
                    e.toString());
            mdc.setRollbackOnly();
        }
    }
}
