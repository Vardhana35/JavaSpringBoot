package com.tcs.Java8Features.streams;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class Examples {

	public static void main(String[] args) {
		
		List<Integer> intlst=Arrays.asList(2,15,40,58,32,46,2,40,15);
		List<Integer> seclst=Arrays.asList(29,20,49,58);
		
		Set<Integer> set=new HashSet<>();
		
		List<String> strlst=Arrays.asList("hello","Naga","deekshi","vardhana","hari","hello");
		
		System.out.println("even numbers in the list: ");//1
		intlst.stream().filter(x->x%2==0).forEach(System.out::println);
	
		System.out.println("Strings in the list to uppercase: ");//2
		strlst.stream().map(x->x.toUpperCase()).forEach(System.out::println);
		
		Set<Integer> s=intlst.stream().filter(x->!set.add(x)).collect(Collectors.toSet());//3
		System.out.println("duplicate numbers in the list: "+s);
		
		int first=intlst.stream().filter(x->x>10).distinct().findFirst().get();//4
		System.out.println("first no>10: "+first);
		
		System.out.println("sorted in descending order: ");//5
		intlst.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
		
		int sum=intlst.stream().reduce((x,y)->x+y).get();//6
		System.out.println("sum of nos in the list: "+sum);
		
		Map<String,Long> map=strlst.stream().collect(Collectors.groupingBy(x->x,Collectors.counting()));
		System.out.println("count of words in the list: "+map);//7
		
		int max=intlst.stream().distinct().max((x,y)->x.compareTo(y)).get();
		System.out.println("max number in the list: "+max);//8
		
        List<List<Integer>> merlst=Arrays.asList(intlst,seclst);//9
		
		List<Integer> res=merlst.stream().flatMap(List::stream).distinct().collect(Collectors.toList());
		System.out.println("removing duplicates from the merged list: "+res);
		
		System.out.println("reverse sort strings by length: ");//10
		strlst.stream().distinct().sorted((x,y)->Integer.compare(y.length(),x.length())).forEach(System.out::println);		
		
		//other way to reverse sort strings by length
		//strlst.stream().distinct().sorted(Comparator.comparingInt(String::length).reversed()).forEach(System.out::println);
	
		System.out.println("square of each no in the list: ");//11
		intlst.stream().map(x->x*x).distinct().forEach(System.out::println);
	
		List<String> str=Arrays.asList("one","two","three");//12
		String concat=str.stream().collect(Collectors.joining(","));
		System.out.println("concat of strings in the list: "+concat);
		
		List<String> l= Arrays.asList("one","two","three","eight");//13
		Map<Integer,List<String>> m=l.stream().collect(Collectors.groupingBy(y->y.length()));
		//m.forEach((x,y)->System.out.println(x+" "+y));
		System.out.println("group strings by length: "+m);
		
		Integer min=merlst.stream().flatMap(List::stream).distinct().min((x,y)->x.compareTo(y)).get();
		System.out.println("min val in the lsit: "+min);//14
		
		System.out.println("2nd max value: ");//15
		merlst.stream().flatMap(List::stream).distinct().sorted(Comparator.reverseOrder()).skip(1).limit(1).forEach(System.out::println);
		
		String s1="banana";//16
		List<Character> ch=new ArrayList<>();
		for(int i=0;i<s1.length();i++) {
			ch.add(s1.charAt(i));
		}
		Map<Character,Long> freq=ch.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		System.out.println("freq of characters: "+freq);
		
		//other way for 16
		Map<Character,Long> freq1=s1.chars().mapToObj(g->(char)g).collect(Collectors.groupingBy(x->x,Collectors.counting()));
		System.out.println("freq of characters: "+freq1);
		
		//17
		Predicate<String> f=(x)->x.toLowerCase().equals(new StringBuffer(x).reverse().toString());
		System.out.println("palindrome check of madam: "+f.test("madam"));
		System.out.println("palindrome check of sir: "+f.test("sir"));
		
		//18
		System.out.println("sorted order of the list: ");
		merlst.stream().flatMap(List::stream).distinct().sorted().forEach(System.out::println);
		
		//19
		System.out.println("removing duplicates from the list: ");
		merlst.stream().flatMap(List::stream).distinct().forEach(System.out::println);
		
		//20
		
		Set<Character> seen=new HashSet<>();
		String str1="hello";
		Optional<Character> firstRepeated=str1.chars().mapToObj(c->(char)c).filter(c->!seen.add(c)).findFirst();
		
		if(firstRepeated.isPresent()) {
			System.out.println("repeated char: "+firstRepeated.get());
		}
		else {
			System.out.println("No repeated character found");
		}
		
	}
}
