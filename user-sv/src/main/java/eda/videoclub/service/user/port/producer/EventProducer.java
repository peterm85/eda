package eda.videoclub.service.user.port.producer;

import eda.videoclub.service.user.domain.entity.UserValidation;

public interface EventProducer {

  void sendMessage(UserValidation command);
}
