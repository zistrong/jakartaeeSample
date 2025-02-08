package com.zistrong.jakartaee.exception;

import jakarta.ejb.ApplicationException;

@ApplicationException(rollback = true)
public class BaseRollBackException extends Exception{

    public BaseRollBackException() {
    }

    public BaseRollBackException(String message) {
        super(message);
    }

    public BaseRollBackException(String message, Throwable cause) {
        super(message, cause);
    }

    public BaseRollBackException(Throwable cause) {
        super(cause);
    }

    public BaseRollBackException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
