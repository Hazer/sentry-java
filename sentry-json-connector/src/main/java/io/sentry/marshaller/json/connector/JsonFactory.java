package io.sentry.marshaller.json.connector;

import java.io.IOException;
import java.io.OutputStream;

public interface JsonFactory {
    JsonGenerator createGenerator(OutputStream destination) throws IOException;
}
