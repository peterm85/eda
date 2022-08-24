package eda.videoclub.service.user.adapter.producer;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import eda.videoclub.messaging.message.UserValidatedEvent;
import eda.videoclub.service.user.domain.entity.UserValidation;

@Component
public class UserValidationToUserValidatedEventConverter
    implements Converter<UserValidation, UserValidatedEvent> {

  @Override
  public UserValidatedEvent convert(final UserValidation source) {

    return UserValidatedEvent.builder()
        .id(source.getId())
        .imdbId(source.getImdbId())
        .userId(source.getUserId())
        .build();
  }
}
