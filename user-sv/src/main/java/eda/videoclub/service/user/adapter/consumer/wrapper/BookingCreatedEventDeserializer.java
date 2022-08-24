package eda.videoclub.service.user.adapter.consumer.wrapper;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;

import eda.videoclub.messaging.message.BookingCreatedEvent;

public class BookingCreatedEventDeserializer extends JsonDeserializer<BookingCreatedEvent> {

  @Override
  public BookingCreatedEvent deserialize(final JsonParser jp, final DeserializationContext ctxt)
      throws IOException {
    final ObjectMapper mapper = (ObjectMapper) jp.getCodec();
    return mapper.readValue(jp.getValueAsString(), BookingCreatedEvent.class);
  }
}
