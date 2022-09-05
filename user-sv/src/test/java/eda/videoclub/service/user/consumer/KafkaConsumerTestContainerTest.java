package eda.videoclub.service.user.consumer;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

import eda.videoclub.messaging.message.BookingCreatedEvent;
import eda.videoclub.messaging.message.BookingStatusEnum;
import eda.videoclub.messaging.test.KafkaServerTestProvider;
import eda.videoclub.messaging.wrapper.base.Schema;
import eda.videoclub.service.user.adapter.consumer.BookingCreatedEventToUserValidationConverter;
import eda.videoclub.service.user.adapter.consumer.KafkaConsumer;
import eda.videoclub.service.user.adapter.consumer.wrapper.BookingCreatedEventWrapperMessage;
import eda.videoclub.service.user.command.UserValidationCommand;
import eda.videoclub.service.user.command.handler.UserValidationCommandHandler;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ActiveProfiles("test")
@SpringBootTest
@DirtiesContext
@ContextConfiguration(initializers = {KafkaServerTestProvider.KafkaServerInitializer.class})
@ExtendWith(MockitoExtension.class)
public class KafkaConsumerTestContainerTest {

  @Value("${user-sv.topic.consume.bookingCreated}")
  private String topic;

  @InjectMocks private KafkaConsumer kafkaConsumer;

  @Autowired private KafkaTemplate<String, Object> kafkaTemplate;

  @Mock private BookingCreatedEventToUserValidationConverter converter;

  @Mock private UserValidationCommandHandler userValidationCommandHandler;

  @Test
  public void listenTest() {
    // given
    final Schema schema = Schema.builder().build();
    final BookingCreatedEvent bookingCreatedEvent =
        BookingCreatedEvent.builder()
            .id(UUID.randomUUID().toString())
            .imdbId("12345")
            .userId(UUID.randomUUID().toString())
            .status(BookingStatusEnum.CREATED)
            .build();

    final BookingCreatedEventWrapperMessage bookingCreatedWrapper =
        BookingCreatedEventWrapperMessage.builder()
            .schema(schema)
            .payload(bookingCreatedEvent)
            .build();

    kafkaTemplate.send(topic, bookingCreatedWrapper);

    // when
    final ArgumentCaptor<BookingCreatedEvent> captor =
        ArgumentCaptor.forClass(BookingCreatedEvent.class);

    Mockito.when(converter.convert(captor.capture()))
        .thenReturn(UserValidationCommand.builder().build());
    Mockito.doNothing().when(userValidationCommandHandler).handle(Mockito.any());

    kafkaConsumer.listen(bookingCreatedWrapper);

    // then
    final BookingCreatedEvent eventPayloadCaptured = captor.getValue();
    assertEquals(bookingCreatedEvent.getId(), eventPayloadCaptured.getId());
    assertEquals(bookingCreatedEvent.getImdbId(), eventPayloadCaptured.getImdbId());
    assertEquals(bookingCreatedEvent.getUserId(), eventPayloadCaptured.getUserId());
    assertEquals(bookingCreatedEvent.getStatus(), eventPayloadCaptured.getStatus());
  }
}
