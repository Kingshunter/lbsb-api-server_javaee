package com.lbsb.core.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lbsb.core.model.User;
import com.lbsb.core.service.UserService;

@Controller
@RequestMapping("/find")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/user", method = RequestMethod.GET)
	public void find() {
		System.out.println("11111");
		User user = userService.getUserById(1);
		System.out.println(user);
	}
}
