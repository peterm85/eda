package eda.videoclub.messaging.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.AsyncListenableTaskExecutor;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerializer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@EnableKafka
@Configuration
public class KafkaConfig {

  @Value("${spring.kafka.bootstrap-servers}")
  private String bootstrapAddress;

  @Bean
  public Map<String, Object> consumerConfigs() {
    Map<String, Object> configMap = new HashMap<>();
    configMap.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
    configMap.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
    configMap.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
    configMap.put(JsonDeserializer.TRUSTED_PACKAGES, "*");
    configMap.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
    configMap.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, true);

    configMap.put(
        ConsumerConfig.MAX_POLL_INTERVAL_MS_CONFIG,
        "200000"); // Max time to poll for new records again by the processing thread. If it cannot
    // process all the records yet, the heartbeat thread will detect this case and it will send a
    // leave-group request to the broker.
    configMap.put(
        ConsumerConfig.MAX_POLL_RECORDS_CONFIG, "100"); // Number of records per consumer poll
    configMap.put(
        ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG,
        "40000"); // Max time to send a heartbeat by the heardbeat thread.

    return configMap;
  }

  @Bean
  public ConsumerFactory<String, Object> consumerFactory() {
    return new DefaultKafkaConsumerFactory<>(consumerConfigs());
  }

  @Bean("kafkaContainerFactory")
  public ConcurrentKafkaListenerContainerFactory<String, Object>
      concurrentKafkaListenerContainerFactory() {

    final ConcurrentKafkaListenerContainerFactory<String, Object> factory =
        new ConcurrentKafkaListenerContainerFactory<>();
    factory.setConsumerFactory(consumerFactory());
    factory.setConcurrency(2); // Represents the number of threads; each thread creates a Consumer;
    // they run in parallel
    factory.getContainerProperties().setConsumerTaskExecutor(kafkaConsumerListenerAsyncExecutor());

    return factory;
  }

  private AsyncListenableTaskExecutor kafkaConsumerListenerAsyncExecutor() {
    final ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
    executor.setCorePoolSize(6); // Threads availables per instance
    executor.setMaxPoolSize(10);
    executor.setQueueCapacity(100);
    executor.initialize();
    return executor;
  }

  @Bean
  public Map<String, Object> producerConfigs() {
    Map<String, Object> configMap = new HashMap<>();
    configMap.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
    configMap.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
    configMap.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
    configMap.put(ProducerConfig.RETRIES_CONFIG, 3);
    return configMap;
  }

  @Bean
  public KafkaTemplate<String, ?> kafkaTemplate() {

    final ProducerFactory<String, Object> factory =
        new DefaultKafkaProducerFactory<>(producerConfigs());

    return new KafkaTemplate<>(factory);
  }
}
