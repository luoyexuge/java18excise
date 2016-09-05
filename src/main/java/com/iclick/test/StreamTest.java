package com.iclick.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.Map;

public class StreamTest {
	public static void main(String[] args) {
		List<String> stringCollection = new ArrayList<>();
		stringCollection.add("ddd2");
		stringCollection.add("aaa2");
		stringCollection.add("bbb1");
		stringCollection.add("aaa1");
		stringCollection.add("bbb3");
		stringCollection.add("ccc");
		stringCollection.add("bbb2");
		stringCollection.add("ddd1");
		
		System.out.println("----------------filter-------------");
		stringCollection.stream().filter((s)->s.startsWith("a")).forEach(System.out::println);
	    System.out.println("----------------map------------------- ");
		stringCollection.stream().map(String::toUpperCase).sorted((a,b)->b.compareTo(a)).forEach(System.out::println);
		System.out.println("--------------Mathch----------------");
		boolean anystartwithA=stringCollection.stream().anyMatch((s)->s.startsWith("a"));
		System.out.println("anystartwithA is:"+anystartwithA);
		boolean  allStartwithA=stringCollection.stream().allMatch((s)->s.startsWith("a"));
		System.out.println("allStartwithA is :"+allStartwithA);
		boolean  nonStartwithZ=stringCollection.stream().noneMatch((s)->s.startsWith("z"));
		System.out.println("nonStartWihtz is :"+nonStartwithZ);
		
		System.out.println("-------count------------");
		long  startwithB=stringCollection.stream().filter((s)->s.startsWith("b")).count();
		System.out.println("startwihtB is :"+startwithB);
		
		
		System.out.println("-----------reduce-----------");
		Optional<String> reduced=stringCollection.stream().sorted().reduce((s1,s2)->s1+"#"+s2);
		reduced.ifPresent(System.out::println);
		
		
		int max=10000;
		List<String> values=new ArrayList<>(max);
		for(int i=0;i<max;i++){
			UUID  uuid=UUID.randomUUID();
			values.add(uuid.toString());
		}
		
		long t0=System.nanoTime();
		long count=values.parallelStream().sorted().count();
		System.out.println(count);
		long t1=System.nanoTime();
		long mills=TimeUnit.NANOSECONDS.toMillis(t1-t0);
		System.out.println(String.format("paraller sort took :%d ms---%s", mills,"and so on"));
		
		System.out.println("---------Map------------- ");
		Map<Integer,String> map=new HashMap<>();
		for(int i=0;i<10;i++){
			map.putIfAbsent(i, "val"+i);
		}
//		putIfAbsent 不需要我们做额外的存在性检查
		map.forEach((id,val)->System.out.print(val+","));
		
		
	}
}
