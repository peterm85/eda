package eda.videoclub.service.user.command;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserValidationCommand {

  private String bookingId;

  private String imdbId;

  private String userId;
}
