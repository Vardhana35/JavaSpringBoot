package com.tcs.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password4j.BcryptPassword4jPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tcs.security.entity.User;
import com.tcs.security.service.UserService;

@Controller
public class JSPController {

	@Autowired
	private UserService service;

	@RequestMapping("/sam")
	public String getJSPPage() {
		return "sample";
	}

	@RequestMapping("/login")
	public String getLoginPage() {
		return "login";
	}

	@RequestMapping("/wel")
	public String getWelPage() {
		return "welcome";
	}

	@RequestMapping("/register")
	public String getRegisterPage(Model model) {
		model.addAttribute("user", new User());
		return "register";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String getRegisterDetails(@ModelAttribute("user") User user, Model model) {
		PasswordEncoder b = new BcryptPassword4jPasswordEncoder();
		String encryptPassword = b.encode(user.getPassword());
		user.setPassword(encryptPassword);
		service.RegisterDetails(user);
		return "welcome";
	}

}
