package com.ashfaq.reflection.sampleClasses;

public class privateVariablesclass {

	private int age;

	private String name;

	private static String Address;

	public privateVariablesclass(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}

	public privateVariablesclass() {
		super();
		// TODO Auto-generated constructor stub
	}
  
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static String getAddress() {
		return Address;
	}

	public static void setAddress(String address) {
		Address = address;
	}

}
