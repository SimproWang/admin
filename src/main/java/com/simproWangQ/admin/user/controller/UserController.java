package com.simproWangQ.admin.user.controller;

import java.awt.print.Pageable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.simproWangQ.admin.user.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/list")
	public ModelAndView list(Model model) {
		model.addAttribute(userService.listUsers());
		return new ModelAndView("/user/tables", "userModel", model);
	}
	
}
