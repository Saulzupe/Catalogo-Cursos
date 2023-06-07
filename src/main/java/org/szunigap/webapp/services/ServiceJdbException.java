package org.szunigap.webapp.services;

public class ServiceJdbException extends RuntimeException{
    public ServiceJdbException(String message) {
        super(message);
    }

    public ServiceJdbException(String message, Throwable cause) {
        super(message, cause);
    }
}
