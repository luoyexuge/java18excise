package com.iclick.test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class LambdaTest {

	public static void main(String[] args) {
		
		//labmda method
		String del = ",";
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
		list.forEach((Integer e) -> {
			System.out.print(e + del);
			System.out.print(e * 100 + del);
		});
		
	//sort metod	
	List<String> listsort=Arrays.asList("a","b","c","d");
	System.out.println(listsort);
	listsort.sort((e1,e2)->e2.compareTo(e1));
	System.out.println(listsort);

	}

}
