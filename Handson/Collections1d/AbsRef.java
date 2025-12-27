package com.tcs.Handson.Collections1d;

import java.util.Comparator;

public class AbsRef implements Comparator<Integer>{

	@Override
	public int compare(Integer o1, Integer o2) {
		int cmp=Integer.compare(Math.abs(o1), Math.abs(o2));
		if (cmp!=0)
		return cmp;
	return 0;
	}

}
