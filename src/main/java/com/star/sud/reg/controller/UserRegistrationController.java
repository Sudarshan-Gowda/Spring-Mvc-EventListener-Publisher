/**
 * 
 */
package com.star.sud.reg.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.star.sud.reg.dto.UserRegistration;
import com.star.sud.reg.service.IUserRegistrationService;
import com.star.sud.reg.status.ServiceStatus;
import com.star.sud.reg.status.ServiceStatus.STATUS;

/**
 * @author Sudarshan
 *
 */
@Controller
public class UserRegistrationController {

	// Static Attributes
	//////////////////////
	private static final Logger log = Logger.getLogger(UserRegistrationController.class);

	// Attributes
	///////////////
	@Autowired
	private IUserRegistrationService service;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getLandingPage(Model model) {
		log.debug("getLandingPage");
		try {

			model.addAttribute("userReg", new UserRegistration());

		} catch (Exception e) {
			log.error("getLandingPage", e);
		}
		return "home";
	}

	@RequestMapping(value = "/userReg", method = RequestMethod.POST)
	public String saveUserReg(Model model, @ModelAttribute UserRegistration dto) {
		log.debug("saveUserReg");
		try {
			if (null == dto)
				throw new Exception("dto param is null or empty");

			ServiceStatus status = service.saveUserDetails(dto);
			if (status != null && status.getStatus().equals(STATUS.SUCCESS)) {
				model.addAttribute("msgsuccess", "Successfully performed!!");
				model.addAttribute("isDisabled", Boolean.TRUE);
				model.addAttribute("filePath", status.getResult());
			} else {
				model.addAttribute("msgdanger", "Failed to process");
				model.addAttribute("isDisabled", Boolean.FALSE);
			}

			model.addAttribute("userReg", dto);

		} catch (Exception e) {
			log.error("saveUserReg", e);
		}
		return "home";

	}

}
