package eda.videoclub.service.user.adapter.producer;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;

import eda.videoclub.messaging.message.UserInvalidatedEvent;
import eda.videoclub.messaging.message.UserValidatedEvent;
import eda.videoclub.service.user.command.UserValidationCommand;
import eda.videoclub.service.user.domain.entity.RejectionReasonVO;
import eda.videoclub.service.user.port.producer.EventProducer;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class KafkaProducer implements EventProducer {

  @Value("${user-sv.topic.produces.userValidated}")
  private String topicName;

  @Value("${user-sv.topic.produces.userInvalidated}")
  private String errorTopicName;

  @Autowired private UserValidationToUserValidatedEventConverter converter;
  @Autowired private UserValidationToUserInvalidatedEventConverter errorConverter;

  @Autowired private KafkaTemplate<String, Object> kafkaTemplate;

  @Override
  public SendResult<String, ?> sendMessage(final UserValidationCommand command) {

    final UserValidatedEvent event = converter.convert(command);

    log.info("Publishing event: " + event);
    return kafkaTemplate.send(topicName, UUID.randomUUID().toString(), event).completable().join();
  }

  @Override
  public SendResult<String, ?> sendErrorMessage(
      final UserValidationCommand command, final RejectionReasonVO reason) {

    final UserInvalidatedEvent event = errorConverter.convert(command, reason);

    log.info("Publishing event: " + event);
    return kafkaTemplate
        .send(errorTopicName, UUID.randomUUID().toString(), event)
        .completable()
        .join();
  }
}
