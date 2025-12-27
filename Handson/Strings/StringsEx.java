package com.tcs.Handson.Strings;

public class StringsEx {
	String str1 = "Tom:I am from Australia";
	String str2 = "Rick:I am from Canada";

	public void displayNameCntry() {

		String str[] = str1.split(":");

		String str1[] = str2.split(":");

		
		 //System.out.println(str[0]+" "+str[str.length-1]);
		 //System.out.println(str1[0]+" "+str1[str1.length-1]);
		 

		for (int i = 0; i < str.length; i++) {
			System.out.println(str[i]);
		}

		for (int i = 0; i < str1.length; i++) {
			System.out.println(str1[i]);
		}

	}
	
    void displaySum() {
    	int sum1=0;
    	int sum2=0;
    
	String[] arr = {"arun#12#12#12", "deepak#13#12#12"};
	String[] s1=arr[0].split("#");
	String[] s2=arr[1].split("#");
	for(int i=1;i<s1.length;i++) {
		sum1+=Integer.parseInt(s1[i]);
	}
	
	for(int i=1;i<s2.length;i++) {
		sum2+=Integer.parseInt(s1[i]);
	}
	if(sum1>sum2) {
		System.out.println("max sum:"+sum1);
	}
	else {
		System.out.println("max sum:"+sum2);
	}
   }
    
    public void concatStrings() {
    	String input1="hello";
    	String input2="hii";
        int m=input1.length();
        int n=input2.length();
    	if  (m==n) {
    		System.out.println(input1+input2);
    	}
    	else if (m>n) {
    		System.out.println(input1.substring(m-n,m)+input2);
    	}
    	else {
    		System.out.println(input1.substring(n-m,n)+input2);
    	}
    	
    }
    
    public void countVowels() {
    	String input1="Naga Vardhana";
    	input1.toLowerCase();
    	int cnt=0;
    	for(int i=0;i<input1.length();i++) {
    	if (input1.charAt(i)=='a'|| input1.charAt(i)=='e'|| input1.charAt(i)=='i' ||input1.charAt(i)=='o'|| input1.charAt(i)=='u'){
    		cnt++;
    		}
    	}
    	System.out.println("Count of vowels in "+input1 +":" +cnt);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringsEx s1 = new StringsEx();
		s1.displayNameCntry();
		
		s1.displaySum();
		
		s1.concatStrings();
		
		s1.countVowels();
	}

}
