package com.bayviewglen.dayone;

import java.awt.List;
import java.util.ArrayList;

public class Driver {

	public static void main(String[] args) {
		Animal x; // reference to an Animal (Any kind of Animal)
		//x = new Animal(); // You cannot instantiate interfaces
		
		//Animal.repeat();		// static methods and variables can be called directly through the interface
		Animal h = new Puppy("kj");
		//h.repeat("Test");
		System.out.println(h);
		//Dog dog1 = new Dog("Black"); 		// A Dog is a Dog but cannot be instantiated since it is abstract
		//x = new Dog("White");				// a Dog is an Animal - see above
		
		//dog1.setHairColour("Orange");		
		
		//x.setHairColour("Yellow");			// Can only access methods exposed through Animal
		
		Animal animal = new Puppy("Grey");
		animal.eat(20, "carrots");
		// animal.setColour("Black");			// bruh no
		
		Dog dog2 = null;
		if (animal instanceof Dog)				
			dog2 = (Dog)animal;
		if (dog2 instanceof Puppy)				
			((Puppy)dog2).makeAccident("kid\'s Room!");
		//dog3.sleep(6);
		dog2.sleep(6);
		animal.sleep(6);
		
	}

}
