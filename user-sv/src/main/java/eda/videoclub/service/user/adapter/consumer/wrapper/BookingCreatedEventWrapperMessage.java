package eda.videoclub.service.user.adapter.consumer.wrapper;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import eda.videoclub.messaging.message.BookingCreatedEvent;
import eda.videoclub.messaging.wrapper.base.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookingCreatedEventWrapperMessage {

  @JsonIgnore private Schema schema;

  @JsonDeserialize(using = BookingCreatedEventDeserializer.class)
  private BookingCreatedEvent payload;
}
