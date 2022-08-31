package eda.videoclub.service.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eda.videoclub.service.user.domain.entity.User;
import eda.videoclub.service.user.port.repository.UserRepository;

@Service
public class UserService {

  @Autowired private UserRepository userRepository;

  public User createUser(final User user) {
    return userRepository.create(user);
  }

  public boolean validate(final String userId) {

    return userRepository.existUser(userId);
  }
}
