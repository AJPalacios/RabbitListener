package com.example.rabbitlistenerproject;

import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQExchangeConfiguration {
    // Configuracion de intercambio

    // Way number one to create exchanges
    @Bean
    Exchange exampleExchange() {
        return new TopicExchange("ExampleExchange");
    }

    // With ExchangeBuilder

    @Bean
    Exchange example2ndExchange() {
        return ExchangeBuilder.directExchange("Example2ndExchange")
                .autoDelete()
                .internal()
                .build();
    }

    @Bean
    Exchange newExchange() {
        return ExchangeBuilder.topicExchange("TopicTestExchange")
                .autoDelete()
                .durable(true)
                .internal()
                .build();
    }

    @Bean
    Exchange fanOutExchange() {
        return ExchangeBuilder.fanoutExchange("FanoutTestExchange")
                .autoDelete()
                .durable(false)
                .internal()
                .build();
    }

    // Headers Exchange Configuration
    @Bean
    Exchange headersExchange() {
        return ExchangeBuilder.headersExchange("HeadersTestExchange")
                .internal()
                .durable(true)
                .ignoreDeclarationExceptions()
                .build();
    }
}
