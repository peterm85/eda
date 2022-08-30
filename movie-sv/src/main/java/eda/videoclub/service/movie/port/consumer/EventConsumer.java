package eda.videoclub.service.movie.port.consumer;

import eda.videoclub.messaging.message.UserValidatedEvent;

public interface EventConsumer {
  void listen(UserValidatedEvent event);
}
