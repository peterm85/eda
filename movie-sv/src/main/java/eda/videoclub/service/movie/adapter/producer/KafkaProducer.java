package eda.videoclub.service.movie.adapter.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import eda.videoclub.messaging.message.MovieReservedEvent;
import eda.videoclub.service.movie.command.MovieReservationCommand;
import eda.videoclub.service.movie.port.producer.EventProducer;

@Component
public class KafkaProducer implements EventProducer {

  @Value("${movie-sv.topic.produces.movieReserved}")
  private String topicName;

  @Autowired private MovieReservationToMovieReservedEventConverter converter;

  @Autowired private KafkaTemplate<String, MovieReservedEvent> kafkaTemplate;

  @Override
  public void sendMessage(final MovieReservationCommand command) {

    final MovieReservedEvent event = converter.convert(command);

    kafkaTemplate.send(topicName, event);
  }
}
