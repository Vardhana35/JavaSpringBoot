package com.tcs.Handson.Collections1d;

import java.util.*;

public class AccountExample2 {

	public static void main(String[] args) {
		Account a1=new Account(110,"srinu",5000);
		Account a2=new Account(100,"krishna",52000);
		Account a3=new Account(130,"hari",15000);
		a1.setCustomerRefNo("a1");
		a2.setCustomerRefNo("a2");
		a3.setCustomerRefNo("a3");
		//new AccouuntRefSort() will display the data in the sorted order of customerRefNo
		SortedSet<Account> ss=new TreeSet<>(new AccountRefSort());
		ss.add(a1);
		ss.add(a2);
		ss.add(a3);
		
		for(Account a:ss) {
			System.out.println(a.getAccno()+" "+a.getAccname()+" "+a.getCustomerRefNo());
		}
		
	}
}
