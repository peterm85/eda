package eda.videoclub.service.booking.port.consumer;

import eda.videoclub.messaging.message.MovieRejectedEvent;
import eda.videoclub.messaging.message.MovieReservedEvent;
import eda.videoclub.messaging.message.UserInvalidatedEvent;

public interface EventConsumer {
  void listen(MovieReservedEvent event);

  void listen(MovieRejectedEvent event);

  void listen(UserInvalidatedEvent event);
}
