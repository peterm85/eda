package eda.videoclub.messaging.message;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class BookingCreatedEvent {

  @JsonAlias("_id")
  @JsonDeserialize(using = ObjectIdDeserializer.class)
  private String id;

  private String imdbId;

  private String userId;

  private BookingStatus status;
}
