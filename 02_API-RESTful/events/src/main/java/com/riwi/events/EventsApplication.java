package com.riwi.events;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EventsApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventsApplication.class, args);

		System.out.println("Hola pepe");
	}
}