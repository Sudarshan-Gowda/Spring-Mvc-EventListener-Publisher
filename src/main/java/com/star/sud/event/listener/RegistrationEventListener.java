package com.star.sud.event.listener;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationListener;

import com.star.sud.event.RegistrationEvent;
import com.star.sud.event.User;

public class RegistrationEventListener implements ApplicationListener<RegistrationEvent> {

	private static final Logger log = Logger.getLogger(RegistrationEventListener.class);

	public void onApplicationEvent(RegistrationEvent event) {
		log.debug("LogoutEventListener");
		User user = event.getUser();
		System.out.println("I am listening.. for the publisher with data " + user.getUserName());
		// Write your own operation or call your API to handle specific task
	}

}
