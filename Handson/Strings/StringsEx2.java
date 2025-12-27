package com.tcs.Handson.Strings;

public class StringsEx2 {
	void sumOfNum() {
		String[] arr= {"?2AA", "?12", "?ABC", "?c1a?"};
		int sum=0;
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length();j++) {
				if (Character.isDigit(arr[i].charAt(j))){
					sum+=arr[i].charAt(j)-'0';
				}
			}
		}
		System.out.println("sum of digits in the given string array:"+sum);
	}
	
	void exchangeChar() {
		String input1="helloworld";
		char fchar=input1.charAt(0);	
		char lchar=input1.charAt(input1.length()-1);
		String res=lchar+input1.substring(1,input1.length()-1)+fchar;
		System.out.println(res);
		
	}
	
	void countWords() {
		String input1="I work in TCS";
		String[] str=input1.split(" ");
		System.out.println("No of words in "+input1 + ":"+str.length);
	}

	
	boolean emailCheck(String input1) {
		//String input1="test@gmail.com";
		int at=input1.indexOf("@");
		int dot=input1.lastIndexOf(".");
		System.out.println(at+" "+dot);
		if (input1.contains("@") && input1.contains(".") && input1.endsWith(".com")) { 
			if (at==input1.lastIndexOf("@") && dot-at-1>=3 && at>3){
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		StringsEx2 s2=new StringsEx2();
		
		s2.sumOfNum();
		
		s2.exchangeChar();
		
		s2.countWords();
		
		System.out.println(s2.emailCheck("test.abc@gmail."));
		
		}

}
