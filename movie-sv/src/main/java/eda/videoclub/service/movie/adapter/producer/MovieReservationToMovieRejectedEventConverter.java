package eda.videoclub.service.movie.adapter.producer;

import java.util.Optional;

import org.springframework.stereotype.Component;

import eda.videoclub.messaging.message.MovieRejectedEvent;
import eda.videoclub.messaging.message.RejectionReasonEnum;
import eda.videoclub.service.movie.command.MovieReservationCommand;
import eda.videoclub.service.movie.domain.entity.RejectionReasonVO;

@Component
public class MovieReservationToMovieRejectedEventConverter {

  public MovieRejectedEvent convert(
      final MovieReservationCommand source, final RejectionReasonVO reason) {

    return MovieRejectedEvent.builder()
        .bookingId(source.getBookingId())
        .imdbId(source.getImdbId())
        .userId(source.getUserId())
        .reason(
            RejectionReasonEnum.fromString(
                Optional.ofNullable(reason).map(RejectionReasonVO::name).orElse(null)))
        .build();
  }
}
