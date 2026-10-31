package com.ashfaq.reflection.runners;
//Reflection can be used to instantiate classes dynamically at runtime, even if their names are only known at runtime.

public class DynamicInstanceCreator {
	public static Object createInstance(String className) throws Exception {
		Class<?> clazz = Class.forName(className);
		return clazz.getDeclaredConstructor().newInstance();
	}

	public static void main(String[] args) throws Exception {
		Object obj = createInstance("MyClass5");
		System.out.println("Instance created for class: " + obj.getClass().getName());
	}
}

class MyClass5 {
	// MyClass implementation
}
      