package com.example.demo;

import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.cloud.config.java.AbstractCloudConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author bk016677
 * @see https://spring.io/blog/2014/06/03/introducing-spring-cloud
 */
@Slf4j
@Configuration
@Profile("cloud")
public class CloudDataSourceConfiguration extends AbstractCloudConfig {

	@Primary
	@Bean
	public ConnectionFactory rabbitConnectionFactory() {
		CachingConnectionFactory rabbitConnectionFactory = (CachingConnectionFactory) connectionFactory()
				.rabbitConnectionFactory();
		log.info("Configured rabbitConnectionFactory: {}", rabbitConnectionFactory);
		rabbitConnectionFactory.getRabbitConnectionFactory().setAutomaticRecoveryEnabled(false);
		return rabbitConnectionFactory;
	}
}
