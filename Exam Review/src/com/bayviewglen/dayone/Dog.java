package com.bayviewglen.dayone;

public abstract class Dog implements Animal, Comparable {
	private String hairColour;
	private int rested;
	private int belly;
	private int age;
	
	public Dog(){
		System.out.println("ive been called");
		this.hairColour = "black";

	}
	public void repeat(String x){
		System.out.println("yo" + x);
	}
	
	public Dog(String hairColour){
		this.hairColour = hairColour;

	}
	
	public String getHairColour() {
		return hairColour;
	}

	public void setHairColour(String hairColour) {
		this.hairColour = hairColour;
	}

	@Override
	public void eat(int amount, String foodType) {
		belly += amount;
		
	}

	@Override
	public void sleep(int minutes) {
		rested+= minutes;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	

}
