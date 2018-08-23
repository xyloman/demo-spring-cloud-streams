package com.example.demo;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.SubscribableChannel;

public interface SourceBinding {

	public static final String OUTPUT = "demo-output-stream";

	@Output(OUTPUT)
	SubscribableChannel queueMessage();
}
