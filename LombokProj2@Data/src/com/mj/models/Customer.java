package com.mj.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
//@RequiredArgsConstructor
public class Customer {
	//@NonNull
	int custId;
	String custName;
	double billAmount;
}
