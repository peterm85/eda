package eda.videoclub.service.user.command.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eda.videoclub.service.user.command.UserValidationCommand;
import eda.videoclub.service.user.port.producer.EventProducer;
import eda.videoclub.service.user.service.UserService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserValidationCommandHandler {

  @Autowired private UserService userService;
  @Autowired private EventProducer eventProducer;

  public void handle(final UserValidationCommand command) {

    final Boolean exists = userService.validate(command.getUserId());
    if (exists) {
      log.info("{} is a valid user", command.getUserId());
      eventProducer.sendMessage(command);
    } else {
      log.info("{} is NOT a valid user", command.getUserId());
    }
  }
}
