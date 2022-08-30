package eda.videoclub.service.movie.command;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MovieReservationCommand {

  private String bookingId;

  private String imdbId;

  private String userId;
}
