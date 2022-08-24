package eda.videoclub.service.user.adapter.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import eda.videoclub.messaging.message.UserValidatedEvent;
import eda.videoclub.service.user.domain.entity.UserValidation;
import eda.videoclub.service.user.port.producer.EventProducer;

@Component
public class KafkaProducer implements EventProducer {

  @Value("${user-sv.topic.produces.userValidated}")
  private String topicName;

  @Autowired private UserValidationToUserValidatedEventConverter converter;

  @Autowired private KafkaTemplate<String, UserValidatedEvent> kafkaTemplate;

  @Override
  public void sendMessage(UserValidation command) {
    kafkaTemplate.send(topicName, converter.convert(command));
  }
}
