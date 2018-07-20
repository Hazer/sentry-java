package io.sentry.marshaller.json.connector;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;

public interface JsonGenerator extends AutoCloseable {

    void writeStartObject() throws IOException;

    void writeStringField(String fieldName, String value) throws IOException;

    void writeArrayFieldStart(String fieldName) throws IOException;

    void writeString(String value) throws IOException;

    void writeEndArray() throws IOException;

    void writeEndObject() throws IOException;

    void writeNull() throws IOException;

    void writeStartArray() throws IOException;

    void writeFieldName(String fieldName) throws IOException;

    void writeObject(Object value) throws IOException;

    void writeBoolean(boolean state) throws IOException;

    void writeBooleanField(String fieldName, boolean value) throws IOException;

    void writeObjectFieldStart(String fieldName) throws IOException;

    void writeObjectField(String fieldName, Object value) throws IOException;

    void writeNullField(String fieldName) throws IOException;

    void writeNumber(String encodedValue) throws IOException;

    void writeNumber(BigDecimal value) throws IOException;

    void writeNumber(float value) throws IOException;

    void writeNumber(double value) throws IOException;

    void writeNumber(long value) throws IOException;

    void writeNumber(int value) throws IOException;

    void writeNumberField(String fieldName, BigDecimal value) throws IOException;

    void writeNumberField(String fieldName, float value) throws IOException;

    void writeNumberField(String fieldName, double value) throws IOException;

    void writeNumberField(String fieldName, long value) throws IOException;

    void writeNumberField(String fieldName, int value) throws IOException;

    void writeNumber(BigInteger value) throws IOException;

    void close() throws IOException;
}
