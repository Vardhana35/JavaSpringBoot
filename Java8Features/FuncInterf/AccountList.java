package com.tcs.Java8Features.FuncInterf;

import java.util.*;

public class AccountList {

	public static void main(String[] args) {
	
		List<Account> l=new ArrayList<>();
	    Account a1=new Account(103,"abc", 5000);
	    Account a2=new Account(101,"pqrc", 25000);
	    Account a3=new Account(102,"xyz", 50300);
	    a1.setCustomerRefNo("a1");
	    a2.setCustomerRefNo("a2");
	    a3.setCustomerRefNo("a3");
	    
	    l.add(a1);l.add(a2);l.add(a3);
	    
	    
	    //Ascending order
	    for(Account a:l) {
	    	System.out.println(a.getAccno()+" "+a.getAccname()+" "+a.getBalance()+" "+a.getCustomerRefNo());
	    }
	    
	    Collections.sort(l,(x,y)->y.getCustomerRefNo().compareTo(x.getCustomerRefNo()));
	    
	    //Collections.sort(l,Collections.reverseOrder());
	    System.out.println("---------------------------------");
	    //descending order
	    for(Account a:l) {
	    	System.out.println(a.getAccno()+" "+a.getAccname()+" "+a.getBalance()+" "+a.getCustomerRefNo());
	    }
	    
	    
	    
	    
	    
		
	}
}
