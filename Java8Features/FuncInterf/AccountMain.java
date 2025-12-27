package com.tcs.Java8Features.FuncInterf;

import java.util.*;

public class AccountMain {

	public static void main(String[] args) {
		
		Comparator<Account> c1=(a1,a2)->a1.getCustomerRefNo().compareTo(a2.getCustomerRefNo());
	    SortedSet<Account> ss=new TreeSet<>(c1);
	    
	    SortedSet<Account> ss1=new TreeSet<>((a1,a2)->a2.getCustomerRefNo().compareTo(a1.getCustomerRefNo()));
	    
	    Account a1=new Account(103,"abc", 5000);
	    Account a2=new Account(101,"pqrc", 25000);
	    Account a3=new Account(102,"xyz", 50300);
	    a1.setCustomerRefNo("a1");
	    a2.setCustomerRefNo("a2");
	    a3.setCustomerRefNo("a3");
	    
	    ss.add(a1);ss.add(a2);ss.add(a3);
	    
	    ss1.add(a1);ss1.add(a2);ss1.add(a3);
	    
	    //Ascending order
	    for(Account a:ss) {
	    	System.out.println(a.getAccno()+" "+a.getAccname()+" "+a.getBalance()+" "+a.getCustomerRefNo());
	    }
	    
	    System.out.println("---------------------------------");
	    //descending order
	    for(Account a:ss1) {
	    	System.out.println(a.getAccno()+" "+a.getAccname()+" "+a.getBalance()+" "+a.getCustomerRefNo());
	    }
	    
	    
	    
	    
	    
		
	}
}
