package eda.videoclub.service.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eda.videoclub.service.user.domain.entity.User;
import eda.videoclub.service.user.domain.entity.UserValidation;
import eda.videoclub.service.user.port.producer.EventProducer;
import eda.videoclub.service.user.port.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserService {

  @Autowired private UserRepository userRepository;
  @Autowired private EventProducer eventProducer;

  public User createUser(final User user) {
    return userRepository.create(user);
  }

  public void validate(final UserValidation command) {

    log.info("Processing user validation");

    final Boolean exists = userRepository.existUser(command.getUserId());
    if (exists) {
      log.info("{} is a valid user", command.getUserId());
      eventProducer.sendMessage(command);
    } else {
      log.info("{} is NOT a valid user", command.getUserId());
    }
  }
}
