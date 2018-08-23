package com.example.demo;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
public class Controller {

	private final EventSource source;

	@PostMapping("/queue-message")
	public void queueMessage(@RequestBody String body) {
		log.info("Controller received message: {}", body);
		source.queueMessage(body);
	}
}
