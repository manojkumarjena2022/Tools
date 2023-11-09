package com.mj.test;

import com.mj.models.Customer;

public class LombokTest {

	public static void main(String[] args) {
		Customer customer=new Customer();
		customer.setCustId(1);
		customer.setCustName("manoj");
		customer.setBillAmount(2000);
		//System.out.println("Cust Id :"+customer.getCustId()+","+"Cust Name :"+customer.getCustName()+" Cust Bill Amount :"+customer.getBillAmount());
		System.out.println(customer);
		System.out.println("===========================================");
		Customer cust1=new Customer(2, "mj", 5000);
		Customer cust2=new Customer(2, "mj", 5000);
		System.out.println(cust1.hashCode()+" "+cust2.hashCode());//Lombok hascode() our hashcode
		System.out.println(System.identityHashCode(cust1)+" "+System.identityHashCode(cust2));//jvm hascode
		System.out.println(cust1.equals(cust2));
		System.out.println(cust1==cust2);
		System.out.println(cust1);
	}

}
