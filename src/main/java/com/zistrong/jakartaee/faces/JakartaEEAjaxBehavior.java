package com.zistrong.jakartaee.faces;

import jakarta.faces.component.behavior.AjaxBehavior;
import jakarta.faces.event.AbortProcessingException;
import jakarta.faces.event.BehaviorEvent;

public class JakartaEEAjaxBehavior extends AjaxBehavior {

    @Override
    public void broadcast(final BehaviorEvent event) throws
            AbortProcessingException {
        this.doBroadcast(event);
    }

    private void doBroadcast(BehaviorEvent event) throws
            AbortProcessingException {
        super.broadcast(event);
    }
}
