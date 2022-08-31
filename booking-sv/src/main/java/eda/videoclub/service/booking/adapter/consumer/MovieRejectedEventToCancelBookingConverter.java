package eda.videoclub.service.booking.adapter.consumer;

import java.util.Optional;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import eda.videoclub.messaging.message.MovieRejectedEvent;
import eda.videoclub.messaging.message.RejectionReasonEnum;
import eda.videoclub.service.booking.command.CancelBookingCommand;
import eda.videoclub.service.booking.domain.entity.RejectionReasonVO;

@Component
public class MovieRejectedEventToCancelBookingConverter
    implements Converter<MovieRejectedEvent, CancelBookingCommand> {

  @Override
  public CancelBookingCommand convert(final MovieRejectedEvent source) {

    return CancelBookingCommand.builder()
        .bookingId(source.getBookingId())
        .imdbId(source.getImdbId())
        .userId(source.getUserId())
        .reason(
            RejectionReasonVO.fromString(
                Optional.ofNullable(source.getReason()).map(RejectionReasonEnum::name).orElse(null)))
        .build();
  }
}
