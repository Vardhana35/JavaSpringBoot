package com.tcs.Java8Features.predefined_func_inter;

import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class Example1 {

	public static void main(String[] args) {
		
		UnaryOperator<Integer> uo=(a)->a*a;
		System.out.println("Unary op: "+uo.apply(10));
		
		BinaryOperator<Float> bo=(a,b)->a+b;
		System.out.println("Binary op: "+bo.apply(10.2f, 2.3f));
		
		Function<String,Integer> f=(a)->a.length();
		System.out.println("using fun: "+f.apply("hello"));
		
		BiFunction<String, Integer, String> bf=(a,b)->a.substring(b);
		System.out.println("using bifun: "+bf.apply("naga vardhana", 3));
		
		Predicate<Integer> p=(a)->a==10;
		System.out.println("using predicate: "+p.test(8));
		
		BiPredicate<String, String> bip=(a,b)->a.equalsIgnoreCase(b);
		System.out.println("using bipredicate: "+bip.test("hello", "Hello"));
		
		
	}
}
