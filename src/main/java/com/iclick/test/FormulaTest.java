package com.iclick.test;
@FunctionalInterface
interface Formula {
	double caculate(int a);

	default double sqrt(int a) {
		return Math.sqrt(a);
	}
}
//@FunctionalInterface
interface  Converter<F,T>{
	T convert(F from);
}


public class FormulaTest {
	public static void main(String[] args) {
		Formula formula = new Formula() {

			@Override
			public double caculate(int a) {
				return sqrt(a * 100);
			}
		};
		
		System.out.println(formula.caculate(100));
		System.out.println(formula.sqrt(100));
	
		Formula formula1=(from)->Math.sqrt(from*100);
		System.out.println(formula1.caculate(100));
		
	Converter<String,Integer> converter=(from)->Integer.valueOf(from);
	Integer converted=converter.convert("123");
    
	System.out.println(converted);
	
	}


}
