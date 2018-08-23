package com.example.demo;

import static com.example.demo.SourceBinding.OUTPUT;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@EnableBinding(SourceBinding.class)
public class EventSource {

	@Autowired
	@Qualifier(OUTPUT)
	private MessageChannel queue;

	@Output(OUTPUT)
	public void queueMessage(String message) {
		log.info("Queueing message: {}", message);
		queue.send(MessageBuilder.withPayload(message).build());
	}
}
