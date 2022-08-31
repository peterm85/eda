package eda.videoclub.messaging.message;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class MovieRejectedEvent {

  private String bookingId;

  private String imdbId;

  private String userId;

  private RejectionReasonEnum reason;
}
