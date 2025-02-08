package com.zistrong.jakartaee.faces;


import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.validator.Validator;
import jakarta.faces.validator.ValidatorException;

public class PercentValidator implements Validator {
    public PercentValidator() {
    }

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws
            ValidatorException {
    }

    private double min;

    private double max;

    public double getMin() {
        return min;
    }

    public void setMin(double min) {
        this.min = min;
    }

    public double getMax() {
        return max;
    }

    public void setMax(double max) {
        this.max = max;
    }
}
