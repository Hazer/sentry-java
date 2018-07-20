package io.sentry.marshaller.json.connector.classloading;

public interface InstanceLocator<T> {
    T getInstance();
}

