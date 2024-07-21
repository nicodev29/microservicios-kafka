package com.kafka.provider.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.config.TopicConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic generateTopic() {

        Map<String, String> config = new HashMap<>();

        config.put(TopicConfig.CLEANUP_POLICY_CONFIG, TopicConfig.CLEANUP_POLICY_DELETE); // Cleanup policy = delete
        config.put(TopicConfig.RETENTION_MS_CONFIG, "86400000"); // Time retention in milliseconds = 1 day
        config.put(TopicConfig.SEGMENT_BYTES_CONFIG, "1073741824"); // Segment size = 1 GB
        config.put(TopicConfig.MAX_MESSAGE_BYTES_CONFIG, "10485760"); // Maximum message size = 10 MB

        return TopicBuilder.name("Kafka-Topic")
                .partitions(2)
                .replicas(1)
                .configs(config)
                .build();
    }
}
