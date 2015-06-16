package com.lbsb.core.action;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lbsb.base.cache.CacheManager;
import com.lbsb.core.model.User;
import com.lbsb.core.service.UserService;

@Controller
@RequestMapping("/find")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CacheManager mo;
	
	
	@RequestMapping(value="/user", method = RequestMethod.GET)
	public void find() {
		/*System.out.println("11111");
		User user = userService.getUserById(1);
		System.out.println(user);*/
		System.out.println(mo.toString());
		mo.set("aaa", 30, "afafd");
		System.out.println(mo.add("bbb", 30, "112"));
		System.out.println(mo.add("bbb", 30, "112"));
		List<User> list = new ArrayList<User>();
		User user1 = new User();
		user1.setAddress("aaaadfasdf");
		user1.setId(1);
		user1.setName("abc");
		User user2 = new User();
		user2.setAddress("yuiyuiy");
		user2.setId(2);
		user2.setName("errr");
		list.add(user1);
		list.add(user2);
		mo.set("model", user1);
		mo.set("list", list);
		Object value = mo.get("aaa");
		user1 = (User) mo.get("model");
		list = (List<User>) mo.get("list");
		System.out.println(value);
		System.out.println(user1);
		System.out.println(list);
	}
	
	
}
