package eda.videoclub.service.booking.adapter.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import eda.videoclub.messaging.message.MovieRejectedEvent;
import eda.videoclub.messaging.message.MovieReservedEvent;
import eda.videoclub.messaging.message.UserInvalidatedEvent;
import eda.videoclub.service.booking.command.CancelBookingCommand;
import eda.videoclub.service.booking.command.ConfirmBookingCommand;
import eda.videoclub.service.booking.command.handler.CancelBookingCommandHandler;
import eda.videoclub.service.booking.command.handler.ConfirmBookingCommandHandler;
import eda.videoclub.service.booking.port.consumer.EventConsumer;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class KafkaConsumer implements EventConsumer {

  @Autowired private MovieReservedEventToConfirmBookingConverter converter;
  @Autowired private MovieRejectedEventToCancelBookingConverter errorMovieConverter;
  @Autowired private UserInvalidatedEventToCancelBookingConverter errorUserConverter;

  @Autowired private ConfirmBookingCommandHandler confirmBookingCommandHandler;
  @Autowired private CancelBookingCommandHandler cancelBookingCommandHandler;

  @Override
  @KafkaListener(
      topics = "#{'${booking-sv.topic.consume.movieReserved}'}",
      groupId = "#{'${booking-sv.groupId}'}",
      containerFactory = "kafkaContainerFactory")
  public void listen(@Payload final MovieReservedEvent event) {
    log.info("Receiving event: " + event);
    final ConfirmBookingCommand confirmBookingCommand = converter.convert(event);

    confirmBookingCommandHandler.handle(confirmBookingCommand);
  }

  @Override
  @KafkaListener(
      topics = "#{'${booking-sv.topic.consume.movieRejected}'}",
      groupId = "#{'${booking-sv.groupId}'}",
      containerFactory = "kafkaContainerFactory")
  public void listen(@Payload final MovieRejectedEvent event) {
    log.info("Receiving event: " + event);
    final CancelBookingCommand cancelBookingCommand = errorMovieConverter.convert(event);

    cancelBookingCommandHandler.handle(cancelBookingCommand);
  }

  @Override
  @KafkaListener(
      topics = "#{'${booking-sv.topic.consume.userInvalidated}'}",
      groupId = "#{'${booking-sv.groupId}'}",
      containerFactory = "kafkaContainerFactory")
  public void listen(@Payload final UserInvalidatedEvent event) {
    log.info("Receiving event: " + event);
    final CancelBookingCommand cancelBookingCommand = errorUserConverter.convert(event);

    cancelBookingCommandHandler.handle(cancelBookingCommand);
  }
}
