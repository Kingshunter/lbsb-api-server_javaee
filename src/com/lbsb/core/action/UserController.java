package com.lbsb.core.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/find")
public class UserController {
	
	
	@RequestMapping(value="/user", method = RequestMethod.GET)
	public void find() {
		
	}
	
	
}
