package com.zistrong.jakartaee.bean;

import com.zistrong.jakartaee.service.FirstService;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

@ViewScoped
@Named
public class FirstBean implements Serializable {


    private Logger logger = LoggerFactory.getLogger(FirstBean.class);

    private String value;

    private String name;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @PostConstruct
    public void init() {
        logger.info("start....");
    }

    @EJB
    FirstService firstService;

    public void show() {
        this.value = firstService.now();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
