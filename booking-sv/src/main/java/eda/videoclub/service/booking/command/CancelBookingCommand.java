package eda.videoclub.service.booking.command;

import eda.videoclub.service.booking.domain.entity.RejectionReasonVO;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CancelBookingCommand {

  private String bookingId;

  private String imdbId;

  private String userId;

  private RejectionReasonVO reason;
}
