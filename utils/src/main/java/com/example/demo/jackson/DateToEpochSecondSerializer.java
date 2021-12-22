package com.example.demo.jackson;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

/**
 * @author where
 */
public class DateToEpochSecondSerializer extends StdSerializer<Date> {
    public DateToEpochSecondSerializer() {
        super(Date.class);
    }

    @Override
    public void serialize(Date date, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        if (date != null) {
            long second = ZonedDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault()).toEpochSecond();
            jsonGenerator.writeNumber(second);
        }
    }
}
