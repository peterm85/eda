package eda.videoclub.service.user.producer;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.support.SendResult;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

import eda.videoclub.messaging.config.KafkaConfig;
import eda.videoclub.messaging.message.UserInvalidatedEvent;
import eda.videoclub.messaging.message.UserValidatedEvent;
import eda.videoclub.service.user.adapter.producer.KafkaProducer;
import eda.videoclub.service.user.adapter.producer.UserValidationToUserInvalidatedEventConverter;
import eda.videoclub.service.user.adapter.producer.UserValidationToUserValidatedEventConverter;
import eda.videoclub.service.user.command.UserValidationCommand;
import eda.videoclub.service.user.domain.entity.RejectionReasonVO;

import static org.junit.Assert.assertEquals;

@ActiveProfiles("test")
@SpringBootTest(
    classes = {
      KafkaProducer.class,
      UserValidationToUserValidatedEventConverter.class,
      UserValidationToUserInvalidatedEventConverter.class
    })
@DirtiesContext
@EmbeddedKafka
@ContextConfiguration(classes = KafkaConfig.class) // TODO Isolate KafkaConfig
public class KafkaProducerEmbeddedTest {

  @Autowired private KafkaProducer kafkaProducer;

  @Test
  public void sendMessageTest() {
    // given
    final UserValidationCommand command =
        UserValidationCommand.builder()
            .bookingId(UUID.randomUUID().toString())
            .imdbId("12345")
            .userId(UUID.randomUUID().toString())
            .build();

    // when
    final SendResult<String, ?> result = kafkaProducer.sendMessage(command);

    // then
    final UserValidatedEvent resultValue = (UserValidatedEvent) result.getProducerRecord().value();
    assertEquals(command.getBookingId(), resultValue.getBookingId());
    assertEquals(command.getImdbId(), resultValue.getImdbId());
    assertEquals(command.getUserId(), resultValue.getUserId());
  }

  @Test
  public void sendErrorMessageTest() {
    // given
    final UserValidationCommand command =
        UserValidationCommand.builder()
            .bookingId(UUID.randomUUID().toString())
            .imdbId("12345")
            .userId(UUID.randomUUID().toString())
            .build();

    // when
    final SendResult<String, ?> result =
        kafkaProducer.sendErrorMessage(command, RejectionReasonVO.USER_NOT_FOUND);

    // then
    final UserInvalidatedEvent resultValue =
        (UserInvalidatedEvent) result.getProducerRecord().value();
    assertEquals(command.getBookingId(), resultValue.getBookingId());
    assertEquals(command.getImdbId(), resultValue.getImdbId());
    assertEquals(command.getUserId(), resultValue.getUserId());
    assertEquals(RejectionReasonVO.USER_NOT_FOUND.name(), resultValue.getReason().name());
  }
}
