package com.zistrong.jakartaee.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

@WebFilter(filterName = "RestLoginFilter", urlPatterns = "/rest/*")
public class RestLoginFilter implements Filter {

    private static final Logger LOGGER = LoggerFactory.getLogger(RestLoginFilter.class);

    public void init(FilterConfig config) {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {

        LOGGER.info("url= {}", ((HttpServletRequest) request).getRequestURL());

        chain.doFilter(request, response);
    }
}
