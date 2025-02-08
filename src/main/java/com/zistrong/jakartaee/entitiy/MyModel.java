package com.zistrong.jakartaee.entitiy;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@Named("myModel")
@RequestScoped
public class MyModel {

    private String m1;

    public String getM1() {
        return m1;
    }

    public void setM1(String m1) {
        this.m1 = m1;
    }
}
