package eda.videoclub.service.movie.adapter.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import eda.videoclub.messaging.message.UserValidatedEvent;
import eda.videoclub.service.movie.command.MovieReservationCommand;
import eda.videoclub.service.movie.command.handler.MovieReservationCommandHandler;
import eda.videoclub.service.movie.port.consumer.EventConsumer;

@Component
public class KafkaConsumer implements EventConsumer {

  @Autowired private UserValidatedEventToMovieReservationConverter converter;
  @Autowired private MovieReservationCommandHandler movieReservationCommandHandler;

  @Override
  @KafkaListener(
      topics = "#{'${movie-sv.topic.consume.userValidated}'}",
      groupId = "#{'${movie-sv.groupId}'}",
      containerFactory = "kafkaContainerFactory")
  public void listen(@Payload final UserValidatedEvent event) {

    final MovieReservationCommand movieReservationCommand = converter.convert(event);

    movieReservationCommandHandler.handle(movieReservationCommand);
  }
}
