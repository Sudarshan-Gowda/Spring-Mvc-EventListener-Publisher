/**
 * 
 */
package com.star.sud.reg.service;

import com.star.sud.reg.dto.UserRegistration;
import com.star.sud.reg.status.ServiceStatus;

/**
 * @author Sudarshan
 *
 */
public interface IUserRegistrationService {

	/**
	 * @param userDetails
	 * @return
	 */
	ServiceStatus saveUserDetails(UserRegistration userDetails);

}
