package com.zistrong.jakartaee.faces;

import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;

public class JakartaEEStringConverter implements Converter {
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return value == null ? null : value.trim();
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value instanceof String) {
            return ((String) value).trim();
        }
        if (value == null) {
            return null;
        }
        return value.toString();

    }
}
