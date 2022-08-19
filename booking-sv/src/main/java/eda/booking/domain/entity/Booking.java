package eda.booking.domain.entity;

import java.time.Instant;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Booking {

  private String id;

  private String imdbId;

  private String userId;

  private BookingStatus status;

  private Instant lastUpdateDatetime;
}
