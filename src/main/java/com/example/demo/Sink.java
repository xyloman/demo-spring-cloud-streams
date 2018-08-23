package com.example.demo;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@EnableBinding(InputBinding.class)
public class Sink {

	@StreamListener(target = InputBinding.INPUT)
	public void processMessage(String message) {
		log.info("Received message: {}", message);
	}
}
