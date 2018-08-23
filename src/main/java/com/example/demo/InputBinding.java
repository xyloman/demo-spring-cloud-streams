package com.example.demo;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface InputBinding {

	public static final String INPUT = "demo-input-stream";

	@Input(INPUT)
	SubscribableChannel retrievePendingMessage();
}
