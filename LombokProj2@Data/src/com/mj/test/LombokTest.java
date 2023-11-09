package com.mj.test;

import com.mj.models.Customer;

public class LombokTest {

	public static void main(String[] args) {
	
		Customer cust1=new Customer(2, "mj", 5000);
		Customer cust2=new Customer(2, "mj", 5000);
		System.out.println(cust1.hashCode()+" "+cust2.hashCode());//Lombok hascode() our hashcode
		System.out.println(System.identityHashCode(cust1)+" "+System.identityHashCode(cust2));//jvm hascode
		System.out.println(cust1.equals(cust2));
		System.out.println(cust1==cust2);
		System.out.println(cust1);
	}

}
