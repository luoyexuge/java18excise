package com.iclick.test;

import java.util.Optional;

public class OptionalTest {
	public static void main(String[] args) {

		Optional<String> name = Optional.of("zhoumeixu");
		System.out.println(name.get());
		System.out.println(name.isPresent());// 如果值存在返回true，否则返回false。
		Optional<String> someNull = Optional.ofNullable(null);// ofNullable与of方法相似，唯一的区别是可以接受参数为null的情况
		Optional<String> nulltest = Optional.ofNullable(null);
		System.out.println(name.orElseGet(() -> "unknow"));
		System.out.println(someNull.orElseGet(() -> "isnull"));
		System.out.println(nulltest.orElseGet(() -> "is null..."));

		name.ifPresent((value) -> {
			System.out.println("the length of value is :" + value.length());

		});

		Optional<String> upperName = name.map((value) -> value.toUpperCase());

		System.out.println(upperName.orElse("no value found"));

		/*
		 * flatMap方法与map方法类似，区别在于mapping函数的返回值不同。 map方法的mapping函数返回值可以是任何类型T，
		 * 而flatMap方法的mapping函数必须是Optional
		 */

		Optional<String> upperNameFlat = name.flatMap((value) -> Optional.of(value.toUpperCase()));
		System.out.println(upperNameFlat.orElse("no value"));

		// filter如果有值并且满足断言条件返回包含该值的Optional，否则返回空Optional。
		Optional<String> longname = name.filter((value) -> value.length() > 10);
		System.out.println(longname.orElse("The name is less than 10 characters"));

	}

}
