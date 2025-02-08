package com.zistrong.jakartaee.jms;

import jakarta.annotation.Resource;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.jms.ConnectionFactory;
import jakarta.jms.JMSContext;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
/**
 * should create a destination resource named 'jms/sample' in jms resource
 *
 */
@RequestScoped
@Path("/jms")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public class SimpleProducerRest {

    @Resource(lookup = "java:comp/DefaultJMSConnectionFactory")
    private ConnectionFactory connectionFactory;
    @Resource(lookup = "jms/sample")
    private jakarta.jms.Queue queue;

    @Inject
    private JMSContext context1;

    @GET
    @Path("/produce")
    public Response produce() {
        try (JMSContext jmsContext = connectionFactory.createContext()) {
            jmsContext.createProducer().send(queue, System.currentTimeMillis() + "");
        }
        for (int i = 0; i < 100; i++) {
            context1.createProducer().send(queue, System.currentTimeMillis() + "");
        }
        return Response.ok().build();
    }

}
