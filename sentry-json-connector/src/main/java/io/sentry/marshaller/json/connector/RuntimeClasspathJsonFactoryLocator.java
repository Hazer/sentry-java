package io.sentry.marshaller.json.connector;

import java.util.concurrent.atomic.AtomicReference;

import io.sentry.marshaller.json.connector.classloading.*;


public class RuntimeClasspathJsonFactoryLocator implements InstanceLocator<JsonFactory> {

    static final AtomicReference<JsonFactory> JSON_FACTORY = new AtomicReference<>();

    private static final String JSON_FACTORY_NAME = "io.sentry.marshaller.json.factory.JsonFactoryImpl";
//    private static final String JACKSON_FACTORY_NAME = "io.sentry.marshaller.json.factory.JsonFactoryImpl";
//    private static final String GSON_FACTORY_NAME = "io.sentry.marshaller.json.factory.JsonFactoryImpl";

    @SuppressWarnings("unchecked")
    @Override
    public JsonFactory getInstance() {
        JsonFactory jsonFactory = JSON_FACTORY.get();
        if (jsonFactory == null) {
            jsonFactory = locate();
            assertState(jsonFactory != null, "locate() cannot return null.");
            if (!compareAndSet(jsonFactory)) {
                jsonFactory = JSON_FACTORY.get();
            }
        }
        assertState(jsonFactory != null, "factory cannot be null.");
        return jsonFactory;
    }

    @SuppressWarnings("WeakerAccess") //to allow testing override
    protected JsonFactory locate() {
        if (isAvailable(JSON_FACTORY_NAME)) {
            return Classes.newInstance(JSON_FACTORY_NAME);
//        if (isAvailable(JACKSON_FACTORY_NAME)) {
//            return Classes.newInstance(JACKSON_FACTORY_NAME);
//        } else if (isAvailable(GSON_FACTORY_NAME)) {
//            return Classes.newInstance(GSON_FACTORY_NAME);
        } else {
            throw new IllegalStateException("Unable to discover any JsonFactory implementations on the classpath.");
        }
    }

    @SuppressWarnings("WeakerAccess") //to allow testing override
    protected boolean compareAndSet(JsonFactory s) {
        return JSON_FACTORY.compareAndSet(null, s);
    }

    @SuppressWarnings("WeakerAccess") //to allow testing override
    protected boolean isAvailable(String fullyQualifiedName) {
        return Classes.isAvailable(fullyQualifiedName);
    }

    private static void assertState(boolean expression, String message) {
        if (!expression) {
            throw new IllegalStateException(message);
        }
    }
}