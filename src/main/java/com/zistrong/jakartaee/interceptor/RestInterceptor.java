package com.zistrong.jakartaee.interceptor;

import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

import java.io.Serializable;

@Interceptor
@RestInterceptorBinding
public class RestInterceptor implements Serializable {
    @AroundInvoke
    public Object validateRequest(InvocationContext ctx) throws Exception {

        ctx.getTarget().getClass();
        RestInterceptorBinding restInterceptorBinding = ctx.getMethod().getAnnotation(RestInterceptorBinding.class);
        if(restInterceptorBinding != null) {
            String[] values = restInterceptorBinding.value();
        }

        return ctx.proceed();
    }
}
