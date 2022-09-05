package eda.videoclub.service.user.producer;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.support.SendResult;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

import eda.videoclub.messaging.message.UserInvalidatedEvent;
import eda.videoclub.messaging.message.UserValidatedEvent;
import eda.videoclub.messaging.test.KafkaServerTestProvider;
import eda.videoclub.service.user.adapter.producer.KafkaProducer;
import eda.videoclub.service.user.command.UserValidationCommand;
import eda.videoclub.service.user.domain.entity.RejectionReasonVO;

import static org.junit.Assert.assertEquals;

@ActiveProfiles("test")
@SpringBootTest
@DirtiesContext
@ContextConfiguration(initializers = {KafkaServerTestProvider.KafkaServerInitializer.class})
@ExtendWith(MockitoExtension.class)
public class KafkaProducerTestContainerTest {

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
