package eda.videoclub.service.user.adapter.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import eda.videoclub.service.user.adapter.consumer.wrapper.BookingCreatedEventWrapperMessage;
import eda.videoclub.service.user.domain.entity.UserValidation;
import eda.videoclub.service.user.port.consumer.EventConsumer;
import eda.videoclub.service.user.service.UserService;

@Component
public class KafkaConsumer implements EventConsumer {

  @Autowired private BookingCreatedEventToUserValidationConverter converter;
  @Autowired private UserService userService;

  @Override
  @KafkaListener(
      topics = "#{'${user-sv.topic.consume.bookingCreated}'}",
      groupId = "#{'${user-sv.groupId}'}",
      containerFactory = "kafkaListenerContainerFactory",
      properties = {
        "key.deserializer=org.springframework.kafka.support.serializer.JsonDeserializer",
        "spring.json.value.default.type=eda.videoclub.service.user.adapter.consumer.wrapper.BookingCreatedEventWrapperMessage",
        "spring.json.key.default.type=eda.videoclub.messaging.wrapper.base.MongoDBSourceConnectorWrapperKey"
      })
  public void listen(@Payload final BookingCreatedEventWrapperMessage event) {

    final UserValidation userValidationCommand = converter.convert(event.getPayload());

    userService.validate(userValidationCommand);
  }
}
