package com.tcs.nbps.controllers; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tcs.nbps.beans.Account;
import com.tcs.nbps.services.AccountService;

@Controller
public class AccountController {
	
	@RequestMapping("/hom") 
	public String home() {
		return "Home"; 
	}
	
	@RequestMapping("/success")
	public String viewSuccessPage() {
		return "Success";
	}
	
	@Autowired
	private AccountService service;

    @RequestMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("account", new Account());
        return "RegisterAccount";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String processRegister(@ModelAttribute("account") Account account, Model model) {
        PasswordEncoder b = new BCryptPasswordEncoder();
		String encryptPassword = b.encode(account.getPassword());
		account.setPassword(encryptPassword);
		service.create(account);
        // TODO: save account to DB (via AccountRepository)
        model.addAttribute("message", "Registration successfull!");
        return "Success";
    }

    @RequestMapping("/login")
    public String showLoginForm() {
        return "login";
    }


}
