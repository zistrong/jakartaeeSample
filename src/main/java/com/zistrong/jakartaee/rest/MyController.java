package com.zistrong.jakartaee.rest;

import com.zistrong.jakartaee.entitiy.MyModel;
import com.zistrong.jakartaee.entitiy.Production;
import jakarta.inject.Inject;
import jakarta.mvc.Controller;
import jakarta.mvc.Models;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/controller")
@Controller
public class MyController {



    private static final Logger LOGGER = LoggerFactory.getLogger(MyController.class);

    @Inject
    Models models;

    @Inject
    HttpServletRequest httpServletRequest;

    @Inject
    MyModel myModel;


    @GET
    public String index() {

        LOGGER.info(httpServletRequest.getServletPath());
        Production production = new Production();
        production.setId(1L);
        production.setName("p1");
        models.put("time", System.nanoTime());
        models.put("production", production);
        return "/view/production.jsp";
    }
    @GET
    @Path("/url")
    public String url() {

        myModel.setM1("M1");

        return "/view/production.jsp";
    }
}
