package io.sentry.marshaller.json.connector.classloading;

public class InstantiationException extends RuntimeException {
    public InstantiationException(String message, Throwable cause) {
        super(message, cause);
    }
}
