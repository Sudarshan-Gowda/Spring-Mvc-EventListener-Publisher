package com.star.sud.event;

import java.io.Serializable;

public class User implements Cloneable, Serializable {

	// Static Attributes
	//////////////////////
	private static final long serialVersionUID = 802944931125305848L;

	// Attributes
	/////////////////
	private String userName;

	// Constructor
	//////////////
	public User(String userName) {
		this.userName = userName;
	}

	// Properties
	/////////////////
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

}
