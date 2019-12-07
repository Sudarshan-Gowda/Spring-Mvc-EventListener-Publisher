package com.star.sud.event;

import org.springframework.context.ApplicationEvent;

public class RegistrationEvent extends ApplicationEvent {

	// Static Attributes
	//////////////////////
	private static final long serialVersionUID = 5114445351468959159L;

	// Attributes
	///////////////
	private User user;

	public RegistrationEvent(Object source, User user) {
		super(source);
		this.user = user;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

}
