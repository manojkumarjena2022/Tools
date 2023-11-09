package com.mj.models;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@EqualsAndHashCode
/*
 * @AllArgsConstructor
 * 
 * @NoArgsConstructor
 * 
 * @RequiredArgsConstructor
 */
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class Customer {
	/*
	 * @Getter
	 * 
	 * @Setter
	 */
	@NonNull
	int custId;
	@NonNull
	String custName;
	double billAmount;
}
