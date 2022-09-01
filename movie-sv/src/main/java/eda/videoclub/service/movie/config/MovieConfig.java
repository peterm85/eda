package eda.videoclub.service.movie.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class MovieConfig {

  @Value("${movie-sv.topic.produces.movieReserved}")
  private String movieReservedTopic;

  @Value("${movie-sv.topic.produces.movieRejected}")
  private String movieRejectedTopic;

  private static final Integer PARTITIONS = 4;
  private static final Integer REPLICATION_FACTOR = 1;

  @Bean
  public NewTopic createMovieReservedTopic() {
    return TopicBuilder.name(movieReservedTopic)
        .partitions(
            PARTITIONS) // Number of concurrency available => aligned with listener.concurrency
        .replicas(REPLICATION_FACTOR) // Nodes on which messages will be replicated
        .compact() // Selectively remove records where we have most recent update with the same
        // primary key
        .build();
  }

  @Bean
  public NewTopic createMovieRejectedTopic() {
    return TopicBuilder.name(movieRejectedTopic)
        .partitions(
            PARTITIONS) // Number of concurrency available => aligned with listener.concurrency
        .replicas(REPLICATION_FACTOR) // Nodes on which messages will be replicated
        .compact() // Selectively remove records where we have most recent update with the same
        // primary key
        .build();
  }
}
