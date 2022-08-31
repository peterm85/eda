package eda.videoclub.service.booking.command;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ConfirmBookingCommand {

  private String bookingId;

  private String imdbId;

  private String userId;
}
