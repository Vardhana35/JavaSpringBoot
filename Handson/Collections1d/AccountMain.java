package com.tcs.Handson.Collections1d;

import java.util.*;

public class AccountMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// List<Account> l=new ArrayList<>();
		SortedSet<Account> l = new TreeSet<>();
		l.add(new Account(100, "abc", 5000));
		l.add(new Account(200, "pqr", 1000));
		l.add(new Account(300, "xyz", 3000));
		l.add(new Account(400, "abcd", 15000));
		l.add(new Account(500, "abcdef", 25000));

		for (Account a : l) {
			a.displayDetails();
		}
	}

}
