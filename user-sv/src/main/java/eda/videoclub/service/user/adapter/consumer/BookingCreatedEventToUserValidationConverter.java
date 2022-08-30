package eda.videoclub.service.user.adapter.consumer;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import eda.videoclub.messaging.message.BookingCreatedEvent;
import eda.videoclub.service.user.command.UserValidationCommand;

@Component
public class BookingCreatedEventToUserValidationConverter
    implements Converter<BookingCreatedEvent, UserValidationCommand> {

  @Override
  public UserValidationCommand convert(final BookingCreatedEvent source) {

    return UserValidationCommand.builder()
        .bookingId(source.getId())
        .imdbId(source.getImdbId())
        .userId(source.getUserId())
        .build();
  }
}
