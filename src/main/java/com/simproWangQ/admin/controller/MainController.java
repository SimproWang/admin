package com.simproWangQ.admin.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.simproWangQ.admin.user.entity.Authority;
import com.simproWangQ.admin.user.entity.User;
import com.simproWangQ.admin.user.service.AuthorityService;
import com.simproWangQ.admin.user.service.UserService;
/**
 * 主页控制器
 * @author WangQ
 *
 */
@Controller
public class MainController {
	
	private static final Long ROLE_USER_AUTHORITY_ID = 2L;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private AuthorityService authorityService;
	
	@GetMapping("/")
	public String root(){
		return "/index";
	}
	
	@GetMapping("/index")
	public String index(){
		return "/index";
	}
	
	@GetMapping("/login")
	public String login(){
		return "/login";
	}
	
	@GetMapping("/login-error")
	public String loginError(Model model){
		model.addAttribute("loginError", true);
		model.addAttribute("errorMsg", "登陆失败，账号或者密码错误！");
		return "/login";
	}
	
	/**
	 * 注册用户
	 * @param user
	 * @param result
	 * @param redirect
	 * @return
	 */
	@PostMapping("/register")
	public String registerUser(User user) {
		List<Authority> authorities = new ArrayList<>();
		authorities.add(authorityService.getAuthorityById(ROLE_USER_AUTHORITY_ID));
		user.setAuthorities(authorities);
		userService.saveUser(user);
		return "/login";
	}
	
}
