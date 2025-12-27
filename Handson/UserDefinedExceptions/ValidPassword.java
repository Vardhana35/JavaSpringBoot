package com.tcs.Handson.UserDefinedExceptions;

import java.util.regex.Pattern;

public class ValidPassword {
	public void validatePassword(String password) throws PasswordException{
		String regex="^(?=.*\\d)(?=.*[^a-zA-Z0-9\\s]).*$";
		Pattern pattern=Pattern.compile(regex);
		if (password.length()>6 && password.length()<10) {
			if (pattern.matcher(password).matches())
				System.out.println("Valid Password");
		}
		else {
			PasswordException pe=new PasswordException("Invalid");
			throw pe;
		}
	}
	
}
