package com.zistrong.jakartaee.ws;

import com.zistrong.jakartaee.entitiy.Production;
import com.zistrong.jakartaee.service.FirstService;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

import java.util.List;

@Named
@WebService(targetNamespace = "uri:MyAPI")
public class FirstWS {

    @Inject
    FirstService firstService;

    @WebMethod
    public List<Production> getList() {
        return firstService.getProductions();
    }
}
