package eda.videoclub.service.user.adapter.producer;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import eda.videoclub.messaging.message.UserValidatedEvent;
import eda.videoclub.service.user.command.UserValidationCommand;

@Component
public class UserValidationToUserValidatedEventConverter
    implements Converter<UserValidationCommand, UserValidatedEvent> {

  @Override
  public UserValidatedEvent convert(final UserValidationCommand source) {

    return UserValidatedEvent.builder()
        .bookingId(source.getBookingId())
        .imdbId(source.getImdbId())
        .userId(source.getUserId())
        .build();
  }
}
