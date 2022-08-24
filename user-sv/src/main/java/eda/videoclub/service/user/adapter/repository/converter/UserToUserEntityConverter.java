package eda.videoclub.service.user.adapter.repository.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import eda.videoclub.service.user.adapter.repository.entity.UserEntity;
import eda.videoclub.service.user.domain.entity.User;

@Component
public class UserToUserEntityConverter implements Converter<User, UserEntity> {

  @Override
  public UserEntity convert(final User source) {

    return UserEntity.builder()
        .id(source.getId())
        .name(source.getName())
        .address(source.getAddress())
        .age(source.getAge())
        .build();
  }
}
