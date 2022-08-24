package eda.videoclub.service.user.adapter.consumer;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import eda.videoclub.messaging.message.BookingCreatedEvent;
import eda.videoclub.service.user.domain.entity.UserValidation;

@Component
public class BookingCreatedEventToUserValidationConverter
    implements Converter<BookingCreatedEvent, UserValidation> {

  @Override
  public UserValidation convert(final BookingCreatedEvent source) {

    return UserValidation.builder()
        .id(source.getId())
        .imdbId(source.getImdbId())
        .userId(source.getUserId())
        .build();
  }
}
