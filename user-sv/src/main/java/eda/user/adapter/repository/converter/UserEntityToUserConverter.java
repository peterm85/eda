package eda.user.adapter.repository.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import eda.user.adapter.repository.entity.UserEntity;
import eda.user.domain.entity.User;

@Component
public class UserEntityToUserConverter implements Converter<UserEntity, User> {

  @Override
  public User convert(UserEntity source) {

    return User.builder()
        .id(source.getId())
        .name(source.getName())
        .address(source.getAddress())
        .age(source.getAge())
        .build();
  }
}
