package eda.videoclub.service.user.port.producer;

import eda.videoclub.service.user.command.UserValidationCommand;

public interface EventProducer {

  void sendMessage(UserValidationCommand command);
}
