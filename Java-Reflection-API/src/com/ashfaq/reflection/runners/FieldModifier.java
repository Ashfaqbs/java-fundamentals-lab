package com.ashfaq.reflection.runners;

import java.lang.reflect.Field;
//Reflection allows us to access and modify the private fields of a class without using setter methods.

public class FieldModifier {
	public static void modifyPrivateField(Object obj, String fieldName, Object newValue) throws Exception {
		Field field = obj.getClass().getDeclaredField(fieldName);
		field.setAccessible(true); // Bypasses the access checks
		field.set(obj, newValue);
	}

	public static void main(String[] args) throws Exception {
		MyClass1 obj = new MyClass1();
		modifyPrivateField(obj, "privateField", "New Value");
		System.out.println("Modified privateField value: " + obj.getPrivateField());
	}
}

class MyClass1 {
	private String privateField = "Initial Value";

	public String getPrivateField() {
		return privateField;
	}
}
  