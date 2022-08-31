package eda.videoclub.service.booking.adapter.consumer;

import java.util.Optional;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import eda.videoclub.messaging.message.RejectionReasonEnum;
import eda.videoclub.messaging.message.UserInvalidatedEvent;
import eda.videoclub.service.booking.command.CancelBookingCommand;
import eda.videoclub.service.booking.domain.entity.RejectionReasonVO;

@Component
public class UserInvalidatedEventToCancelBookingConverter
    implements Converter<UserInvalidatedEvent, CancelBookingCommand> {

  @Override
  public CancelBookingCommand convert(final UserInvalidatedEvent source) {

    return CancelBookingCommand.builder()
        .bookingId(source.getBookingId())
        .imdbId(source.getImdbId())
        .userId(source.getUserId())
        .reason(
            RejectionReasonVO.fromString(
                Optional.ofNullable(source.getReason())
                    .map(RejectionReasonEnum::name)
                    .orElse(null)))
        .build();
  }
}
