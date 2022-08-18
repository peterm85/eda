package eda.user.adapter.rest.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import eda.user.domain.entity.User;
import eda.user.port.rest.api.model.UserResponse;

@Component
public class UserToUserResponseConverter implements Converter<User, UserResponse> {

  @Override
  public UserResponse convert(final User source) {

    return UserResponse.builder()
        .id(source.getId())
        .name(source.getName())
        .address(source.getAddress())
        .age(source.getAge())
        .build();
  }
}
