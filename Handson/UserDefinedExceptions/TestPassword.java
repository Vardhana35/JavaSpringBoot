package com.tcs.Handson.UserDefinedExceptions;

public class TestPassword {

	public static void main(String[] args) {
		String password="abc123";
		ValidPassword vp=new ValidPassword();
		try {
			vp.validatePassword(password);
		}catch(PasswordException pe){
			pe.printStackTrace();
			//System.err.println(pe.getMessage());
			//System.out.println(pe);
		}
	}

}
