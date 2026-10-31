package com.ashfaq.reflection.runners;

//use reflection to inspect a class's methods, fields, constructors, and annotations at runtime. This is particularly
//useful for debugging or when working with unknown objects.
public class Inspector {
	public static void inspectClass(Object obj) {
		Class<?> clazz = obj.getClass();

		System.out.println("Class Name: " + clazz.getName());
		System.out.println("Methods:");
		for (var method : clazz.getDeclaredMethods()) {
			System.out.println(" - " + method.getName());
		}
		System.out.println("Fields:");
		for (var field : clazz.getDeclaredFields()) {
			System.out.println(" - " + field.getName());
		}
	}

	public static void main(String[] args) {
		MyClass myClass = new MyClass();
		inspectClass(myClass);
	}  
}

class MyClass {
	private String privateField;
	public String publicField;

	private void privateMethod() {
	}

	public void publicMethod() {
	}
}







