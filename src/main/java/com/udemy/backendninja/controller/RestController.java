package com.udemy.backendninja.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.udemy.backendninja.model.ContactModel;
import com.udemy.backendninja.service.ContactService;
import com.udemy.backendninja.service.impl.UserService;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/rest")
public class RestController {
	@Autowired
	@Qualifier("userService")
	private UserService userService;
	@Autowired
	@Qualifier("contactServiceImpl")
	private ContactService contactService;
	
	
	@GetMapping("/checkrest")
	public ResponseEntity<ContactModel> checkRest(){
		//User user = userService.findUserByUsername("admin");
		//User user = new User("Jose", "asdasdasd", true);
		ContactModel contact = contactService.findContactModelById(3);
		
		return new ResponseEntity<ContactModel>(contact, HttpStatus.OK);
	}
}
