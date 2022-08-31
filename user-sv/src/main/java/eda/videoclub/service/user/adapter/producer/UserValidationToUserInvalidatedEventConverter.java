package eda.videoclub.service.user.adapter.producer;

import java.util.Optional;

import org.springframework.stereotype.Component;

import eda.videoclub.messaging.message.RejectionReasonEnum;
import eda.videoclub.messaging.message.UserInvalidatedEvent;
import eda.videoclub.service.user.command.UserValidationCommand;
import eda.videoclub.service.user.domain.entity.RejectionReasonVO;

@Component
public class UserValidationToUserInvalidatedEventConverter {

  public UserInvalidatedEvent convert(
      final UserValidationCommand source, final RejectionReasonVO reason) {

    return UserInvalidatedEvent.builder()
        .bookingId(source.getBookingId())
        .imdbId(source.getImdbId())
        .userId(source.getUserId())
        .reason(
            RejectionReasonEnum.fromString(
                Optional.ofNullable(reason).map(RejectionReasonVO::name).orElse(null)))
        .build();
  }
}
