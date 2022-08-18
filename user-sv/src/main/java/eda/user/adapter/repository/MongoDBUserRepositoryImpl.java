package eda.user.adapter.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import eda.user.adapter.repository.converter.UserEntityToUserConverter;
import eda.user.adapter.repository.converter.UserToUserEntityConverter;
import eda.user.adapter.repository.entity.UserEntity;
import eda.user.domain.entity.User;
import eda.user.port.repository.UserRepository;

@Repository
public class MongoDBUserRepositoryImpl implements UserRepository {

  @Autowired private MongoDBUserDefaultRepository mongoDBMovieDefaultRepository;

  @Autowired private UserToUserEntityConverter movieToMovieEntityConverter;
  @Autowired private UserEntityToUserConverter movieEntityToMovieConverter;

  @Override
  public User create(final User movie) {
    final UserEntity entity = movieToMovieEntityConverter.convert(movie);
    final UserEntity entityResult = mongoDBMovieDefaultRepository.insert(entity);
    return movieEntityToMovieConverter.convert(entityResult);
  }
}
