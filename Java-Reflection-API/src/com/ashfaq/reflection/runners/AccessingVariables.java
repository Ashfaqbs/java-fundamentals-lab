package com.ashfaq.reflection.runners;

import java.lang.reflect.Field;

import com.ashfaq.reflection.sampleClasses.privateVariablesclass;

public class AccessingVariables {

	private static boolean isAnyFieldNotNull(privateVariablesclass privateVariablesclass) {
		// Get all fields of the class
		Field[] fields = privateVariablesclass.getClass().getDeclaredFields();

		// Check if any field has a non-null value
		for (Field field : fields) {
			field.setAccessible(true);
			System.out.println(field);
			try {
				Object value = field.get(privateVariablesclass);
				if (value != null) {
//					return true; // At least one field is not null 
				}
			} catch (IllegalAccessException e) {
				// Handle exception if needed
			}
		}
		return false; // All fields are null
	}

	public static void main(String[] args) {

		privateVariablesclass pp = new privateVariablesclass();

		boolean anyFieldNotNull = isAnyFieldNotNull(pp);
		System.out.println(anyFieldNotNull);
  
	}

}
