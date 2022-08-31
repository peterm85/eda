package eda.videoclub.service.booking.port.consumer;

import eda.videoclub.messaging.message.MovieReservedEvent;

public interface EventConsumer {
  void listen(MovieReservedEvent event);
}
