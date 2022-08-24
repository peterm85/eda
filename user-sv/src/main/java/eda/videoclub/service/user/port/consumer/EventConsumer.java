package eda.videoclub.service.user.port.consumer;

import eda.videoclub.service.user.adapter.consumer.wrapper.BookingCreatedEventWrapperMessage;

public interface EventConsumer {
  void listen(BookingCreatedEventWrapperMessage event);
}
