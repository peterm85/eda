package eda.videoclub.service.user.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class UserConfig {

  @Value("${user-sv.topic.consume.bookingCreated}")
  private String bookingCreatedTopic;

  @Value("${user-sv.topic.produces.userValidated}")
  private String userValidatedTopic;

  @Value("${user-sv.topic.produces.userInvalidated}")
  private String userInvalidatedTopic;

  private static final Integer PARTITIONS = 4;
  private static final Integer REPLICATION_FACTOR = 1;

  @Bean
  public NewTopic createBookingCreatedTopic() {
    return TopicBuilder.name(bookingCreatedTopic)
        .partitions(
            PARTITIONS) // Number of concurrency available => aligned with listener.concurrency
        .replicas(REPLICATION_FACTOR) // Nodes on which messages will be replicated
        .compact() // Selectively remove records where we have most recent update with the same
        // primary key
        .build();
  }

  @Bean
  public NewTopic createUserValidatedTopic() {
    return TopicBuilder.name(userValidatedTopic)
        .partitions(
            PARTITIONS) // Number of concurrency available => aligned with listener.concurrency
        .replicas(REPLICATION_FACTOR) // Nodes on which messages will be replicated
        .compact() // Selectively remove records where we have most recent update with the same
        // primary key
        .build();
  }

  @Bean
  public NewTopic createUserInvalidatedTopic() {
    return TopicBuilder.name(userInvalidatedTopic)
        .partitions(
            PARTITIONS) // Number of concurrency available => aligned with listener.concurrency
        .replicas(REPLICATION_FACTOR) // Nodes on which messages will be replicated
        .compact() // Selectively remove records where we have most recent update with the same
        // primary key
        .build();
  }
}
