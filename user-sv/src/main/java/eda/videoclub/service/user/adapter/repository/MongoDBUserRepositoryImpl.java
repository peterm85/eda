package eda.videoclub.service.user.adapter.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import eda.videoclub.service.user.adapter.repository.converter.UserEntityToUserConverter;
import eda.videoclub.service.user.adapter.repository.converter.UserToUserEntityConverter;
import eda.videoclub.service.user.adapter.repository.entity.UserEntity;
import eda.videoclub.service.user.domain.entity.User;
import eda.videoclub.service.user.port.repository.UserRepository;

@Repository
public class MongoDBUserRepositoryImpl implements UserRepository {

  @Autowired private MongoDBUserDefaultRepository mongoDBMovieDefaultRepository;

  @Autowired private UserToUserEntityConverter userToUserEntityConverter;
  @Autowired private UserEntityToUserConverter userEntityToUserConverter;

  @Override
  public User create(final User user) {
    final UserEntity entity = userToUserEntityConverter.convert(user);
    final UserEntity entityResult = mongoDBMovieDefaultRepository.insert(entity);
    return userEntityToUserConverter.convert(entityResult);
  }

  @Override
  public Boolean existUser(final String userId) {
    return mongoDBMovieDefaultRepository.findById(userId).isPresent();
  }
}
