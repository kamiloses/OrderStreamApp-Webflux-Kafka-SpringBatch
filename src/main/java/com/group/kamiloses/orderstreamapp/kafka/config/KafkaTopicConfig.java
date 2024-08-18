package com.group.kamiloses.orderstreamapp.kafka.config;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaTopicConfig {


    @Value(value = "${spring.kafka.bootstrap-servers}")
    private String bootstrapAddress;

    @Bean
    public KafkaAdmin kafkaAdmin(){
        Map<String, Object> configs = new HashMap<>();
        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG,bootstrapAddress);

   return  new KafkaAdmin(configs);}//KafkaAdmin jest odpowiedzialny za to żeby te wszystkie beany typu NewTopic  zostały przekształcone w rzeczywiste topic w Kafka,pozwala tez na usuwanie topiców


    @Bean
    public NewTopic orderStatusTopic(){
        return TopicBuilder.name("OrderStatusUpdate").
                partitions(5).replicas(1)
                .build();//tworze w ten sposób topic podczas uruchamiania aplikacji


    }

}