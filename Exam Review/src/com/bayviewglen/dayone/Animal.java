package com.bayviewglen.dayone;

public interface Animal {
	public void eat(int amount, String foodType);	// method without body - abstract method
	// public void sleep(int minutes){					// non-static methods cannot have a body (abstract)
	// 	System.out.println("Sleeping for " + minutes + " minutes");
	// }
	
	public void sleep(int minutes);
	
	public static void repeat(String msg){ 			// static methods with bodies are allowed 
		System.out.println(msg + " " + msg);		// static methods belong to the class/Interface
	}
	//public static void repeat();					// static methods MUST have a body
	
	// static must have a body
	// non-static cannot have a body
	
	public static final int CONSTANT  = 20;
	
	public String animalType = "AnImAl TyPe";		// must be initialized
	
	//interfaces can not have private things, and instance variables must be innitialized
}
