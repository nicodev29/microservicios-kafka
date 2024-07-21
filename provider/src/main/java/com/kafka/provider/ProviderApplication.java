package com.kafka.provider;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class ProviderApplication {


    public static void main(String[] args) {
        SpringApplication.run(ProviderApplication.class, args);
    }

    @Bean
    CommandLineRunner init(KafkaTemplate<String, String> kafka) {
        return args -> {
            kafka.send("Kafka-Topic", "Enviando mensaje desde kafka/springboot");
        };
    }

}
