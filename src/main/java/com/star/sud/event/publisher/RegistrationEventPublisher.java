package com.star.sud.event.publisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

import com.star.sud.event.RegistrationEvent;

public class RegistrationEventPublisher implements ApplicationEventPublisherAware {

	@Autowired
	private ApplicationEventPublisher publisher;

	public void publish(RegistrationEvent regEvent) {
		publisher.publishEvent(regEvent);
		System.out.println("I am publishing.. with data - " + regEvent.getUser().getUserName());
	}

	public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
		this.publisher = applicationEventPublisher;

	}

}
