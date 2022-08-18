package eda.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eda.user.domain.entity.User;
import eda.user.port.repository.UserRepository;

@Service
public class UserService {

  @Autowired private UserRepository userRepository;

  public User createUser(final User user) {
    return userRepository.create(user);
  }
}
