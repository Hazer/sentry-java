package io.sentry.marshaller.json.connector.classloading;

public class UnknownClassException extends RuntimeException {
    public UnknownClassException(String msg) {
        super(msg);
    }
}

