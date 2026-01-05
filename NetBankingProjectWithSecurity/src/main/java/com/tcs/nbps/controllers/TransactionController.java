package com.tcs.nbps.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.tcs.nbps.beans.TransactionHistory;
import com.tcs.nbps.services.TransactionService;

@Controller
public class TransactionController {

	@Autowired
	private TransactionService service;

	@GetMapping("/addTransaction")
	public String showTransactionForm(Model model) {
		model.addAttribute("transaction", new TransactionHistory());
		return "RegTransaction";
	}

	@PostMapping("/addTransaction")
	public String processTransaction(@ModelAttribute("transaction") TransactionHistory txn, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			return "RegTransaction";
		}

		// TODO: save transaction to DB
		service.save(txn);
		model.addAttribute("message", "Transaction added successfully!");
		return "Success";
	}
}
