package com.tcs.Handson.Collections1d;

import java.util.Comparator;

public class AccountRefSort implements Comparator<Account>{

	@Override
	public int compare(Account o1, Account o2) {
		// TODO Auto-generated method stub
		return (o1.getCustomerRefNo().compareTo(o2.getCustomerRefNo()));
	}

}
