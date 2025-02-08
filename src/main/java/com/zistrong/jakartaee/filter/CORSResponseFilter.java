package com.zistrong.jakartaee.filter;

import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.container.ContainerResponseContext;
import jakarta.ws.rs.container.ContainerResponseFilter;
import jakarta.ws.rs.core.MultivaluedMap;
import jakarta.ws.rs.ext.Provider;

import java.io.IOException;

@Provider
public class CORSResponseFilter implements ContainerRequestFilter, ContainerResponseFilter {
    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {

        MultivaluedMap<String, String> headers = requestContext.getHeaders();
        headers.add("Access-Control-Allow-Origin", "http://localhost:4200");
        headers.add("Access-Control-Allow-Headers", "Content-Type,needRecalculation,X-XSRF-TOKEN,_csrf");
        headers.add("Access-Control-Expose-Headers", "temporaryRedirect,clientRedirect,_csrf,Content-Disposition");
        headers.add("Access-Control-Allow-Credentials", "true");
    }

    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException {
        MultivaluedMap<String, Object> headers = responseContext.getHeaders();
        headers.add("Access-Control-Allow-Origin", "http://localhost:4200");
        headers.add("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT,OPTIONS");
        headers.add("Access-Control-Allow-Headers", "Content-Type,needRecalculation,X-XSRF-TOKEN,_csrf");
        headers.add("Access-Control-Expose-Headers", "temporaryRedirect,clientRedirect,_csrf,Content-Disposition");
        headers.add("Access-Control-Allow-Credentials", "true");
    }
}
