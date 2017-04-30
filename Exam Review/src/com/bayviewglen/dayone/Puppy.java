package com.bayviewglen.dayone;

public class Puppy extends Dog {
	public Puppy(String abc) {
		System.out.println("yo");
		//super(abc);		// if you want to call your parent's constructor
		int x = 0;		//  super must be first statement in a constructor

	}
	
	public void makeAccident(String where){
		System.out.println("Better get the Spray Bottle ");
	}
	
	public void sleep(int amt){
		amt += 3;
		super.sleep(2*amt);		// in methods u can call your parents any time
	}
	
	public String toString(){
		setAge(6);
		return "" + getAge();
	}

	@Override
	public int compareTo(Object o) {
		if(o instanceof Puppy){
			return this.getAge() - ((Puppy) o).getAge();
		}else{
			throw new IllegalArgumentException("Bruh it aint no puppy");
		}
	}

	// If the child class does not write its own constructor it will attempt to
	// call super() - that's your parents no argument constructor
}
