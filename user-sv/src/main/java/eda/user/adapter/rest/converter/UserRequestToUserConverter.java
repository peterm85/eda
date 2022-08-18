package eda.user.adapter.rest.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import eda.user.domain.entity.User;
import eda.user.port.rest.api.model.UserRequest;

@Component
public class UserRequestToUserConverter implements Converter<UserRequest, User> {

  @Override
  public User convert(final UserRequest source) {

    return User.builder()
        .name(source.getName())
        .address(source.getAddress())
        .age(source.getAge())
        .build();
  }
}
