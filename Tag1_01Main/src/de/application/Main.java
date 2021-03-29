package de.application;



import java.lang.reflect.Method;


import de.dep.Depenccy;



public class Main {

	public static void main(String[] args) throws Exception{
		
		
		
		
//		Depenccy dependency = Depenccy.create().get();
//		dependency.foo();
		
		Object object = Class.forName("de.bitmarck.amphibien.Frosch").newInstance();
		
		Method method = object.getClass().getDeclaredMethod("setGewicht", int.class);
		method.setAccessible(true);
		
		method.invoke(object, -10);
		
		System.out.println(object);
	}

}
