package com.ashfaq.reflection.runners;
//Reflection can invoke both public and private methods of a class.



import java.lang.reflect.Method;

public class MethodInvoker {
    public static void invokePrivateMethod(Object obj, String methodName) throws Exception {
        Method method = obj.getClass().getDeclaredMethod(methodName);
        method.setAccessible(true); // Allows us to invoke private methods
        method.invoke(obj);
    }

    public static void main(String[] args) throws Exception {
        MyClass3 obj = new MyClass3();
        invokePrivateMethod(obj, "privateMethod");
    }
}

class MyClass3 {
    private void privateMethod() {
        System.out.println("Private method invoked.");
    }
}
   