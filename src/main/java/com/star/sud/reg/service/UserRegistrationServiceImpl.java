/**
 * 
 */
package com.star.sud.reg.service;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.star.sud.event.RegistrationEvent;
import com.star.sud.event.User;
import com.star.sud.event.publisher.RegistrationEventPublisher;
import com.star.sud.reg.dto.UserRegistration;
import com.star.sud.reg.status.ServiceStatus;
import com.star.sud.reg.status.ServiceStatus.STATUS;

/**
 * @author Sudarshan
 *
 */
@Service("xlFileGenerationService")
public class UserRegistrationServiceImpl implements IUserRegistrationService {

	// Static Attributes
	//////////////////////
	private static Logger log = Logger.getLogger(UserRegistrationServiceImpl.class);

	// Attributes
	//////////////////////
	@Autowired
	protected HttpServletResponse response;

	@Autowired
	protected RegistrationEventPublisher publisher;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.star.sud.xl.service.IXLFileGenerationService#generateXlFile(com.star.sud.
	 * xl.dto.UserDetails)
	 */
	public ServiceStatus saveUserDetails(UserRegistration userDetails) {
		log.debug("generateXlFile");
		ServiceStatus genStatus = new ServiceStatus();
		try {

			RegistrationEvent event = new RegistrationEvent(this, new User(userDetails.getUserFirstName()));
			publisher.publish(event);
			genStatus.setStatus(STATUS.SUCCESS);

		} catch (Exception e) {
			log.error("generateXlFile", e);
			genStatus.setStatus(STATUS.FAILED);
		}

		return genStatus;
	}

}
