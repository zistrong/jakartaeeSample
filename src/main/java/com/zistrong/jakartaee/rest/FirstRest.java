package com.zistrong.jakartaee.rest;

import com.zistrong.jakartaee.entitiy.Production;
import com.zistrong.jakartaee.interceptor.RestInterceptor;
import com.zistrong.jakartaee.interceptor.RestInterceptorBinding;
import com.zistrong.jakartaee.service.FirstService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.interceptor.Interceptors;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.io.Serializable;
import java.util.List;

@RequestScoped
@Path("/first")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
@Interceptors({RestInterceptor.class})
public class FirstRest implements Serializable {

    @Inject
    FirstService firstService;

    @GET
    @Path("/index/{id}")
    public List<Production> index(@PathParam("id") String id) {
        return firstService.getProductions();
    }

    @RestInterceptorBinding({"abc", "efgg"})
    @POST
    @Path("/index")
    public List<Production> save(Production production) {
        firstService.save(production);
        return firstService.getProductions();
    }

    @DELETE
    @Path("/index/{id}")
    public Response delete(@PathParam("id") String id) {

        return Response.ok().build();
    }
}
