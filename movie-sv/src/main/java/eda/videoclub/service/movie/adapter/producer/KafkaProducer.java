package eda.videoclub.service.movie.adapter.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import eda.videoclub.messaging.message.MovieRejectedEvent;
import eda.videoclub.messaging.message.MovieReservedEvent;
import eda.videoclub.service.movie.command.MovieReservationCommand;
import eda.videoclub.service.movie.domain.entity.RejectionReasonVO;
import eda.videoclub.service.movie.port.producer.EventProducer;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class KafkaProducer implements EventProducer {

  @Value("${movie-sv.topic.produces.movieReserved}")
  private String topicName;

  @Value("${movie-sv.topic.produces.movieRejected}")
  private String errorTopicName;

  @Autowired private MovieReservationToMovieReservedEventConverter converter;
  @Autowired private MovieReservationToMovieRejectedEventConverter errorConverter;

  @Autowired private KafkaTemplate<String, Object> kafkaTemplate;

  @Override
  public void sendMessage(final MovieReservationCommand command) {

    final MovieReservedEvent event = converter.convert(command);

    log.info("Publishing event: " + event);
    kafkaTemplate.send(topicName, event);
  }

  @Override
  public void sendErrorMessage(
      final MovieReservationCommand command, final RejectionReasonVO reason) {

    final MovieRejectedEvent event = errorConverter.convert(command, reason);

    log.info("Publishing event: " + event);
    kafkaTemplate.send(errorTopicName, event);
  }
}
