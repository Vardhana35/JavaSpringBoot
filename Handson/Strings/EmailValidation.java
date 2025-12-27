package com.tcs.Handson.Strings;

public class EmailValidation {
	 
	public static boolean cond1(String s){
		return s.contains("@") && s.contains(".");
	}
	
	public static boolean cond2(String s){
		return s.split("@").length==2;
	}
	
	public static boolean cond3(String s){
		return (s.substring(s.indexOf("@")+1,s.lastIndexOf(".")).length()-1)<=4;	
	}
	
	public static boolean cond3_1(String s){
		String[] str=s.split("@");
	    boolean res=str[1].split("//.")[0].length()>=4;
	    return res;
	}
	
	public static boolean cond4(String s) {
		String str[]=s.split("@");
		return str[0].length()>=3;
	}
	
	public static boolean cond5(String s) {
		return s.endsWith(".com");
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//EmailValidation ev=new EmailValidation();
		String input1="abc.test@gmail.com";
		if (cond1(input1) && cond2(input1) && cond3(input1) && cond4(input1) && cond5(input1))
			System.out.println("crct email validation");
		else
			System.out.println("incrct email validation");	
	}

}
