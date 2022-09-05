package eda.videoclub.messaging.test;

import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.ActiveProfiles;
import org.testcontainers.containers.KafkaContainer;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

@ActiveProfiles("test")
@Testcontainers
@Slf4j
@UtilityClass
public class KafkaServerTestProvider {

  public static final KafkaContainer KAFKA_CONTAINER =
      new KafkaContainer(DockerImageName.parse("confluentinc/cp-kafka:7.1.1"));

  public static class KafkaServerInitializer
      implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    @Override
    public void initialize(final ConfigurableApplicationContext applicationContext) {
      KAFKA_CONTAINER.start();

      TestPropertyValues.of(
              "spring.kafka.bootstrap-servers=" + KAFKA_CONTAINER.getBootstrapServers())
          .applyTo(applicationContext.getEnvironment());

      log.info("Kafka server for test: {}", KAFKA_CONTAINER.getBootstrapServers());
    }
  }
}
