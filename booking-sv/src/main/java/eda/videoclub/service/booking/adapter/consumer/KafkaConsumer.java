package eda.videoclub.service.booking.adapter.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import eda.videoclub.messaging.message.MovieReservedEvent;
import eda.videoclub.service.booking.command.ConfirmBookingCommand;
import eda.videoclub.service.booking.command.handler.ConfirmBookingCommandHandler;
import eda.videoclub.service.booking.port.consumer.EventConsumer;

@Component
public class KafkaConsumer implements EventConsumer {

  @Autowired private MovieReservationEventToConfirmBookingConverter converter;
  @Autowired private ConfirmBookingCommandHandler confirmBookingCommandHandler;

  @Override
  @KafkaListener(
      topics = "#{'${booking-sv.topic.consume.movieReserved}'}",
      groupId = "#{'${booking-sv.groupId}'}",
      containerFactory = "kafkaContainerFactory")
  public void listen(@Payload final MovieReservedEvent event) {

    final ConfirmBookingCommand confirmBookingCommand = converter.convert(event);

    confirmBookingCommandHandler.handle(confirmBookingCommand);
  }
}
