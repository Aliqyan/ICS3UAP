package com.bayviewglen.dayfour;

import java.util.List;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public class ExampleTwo {

	public static void main(String[] args) {
		List<String> words = new ArrayList<String>();
		words = new LinkedList<String>();
		
		words.add("bye");
		words.add("good");
		words.add("yolo");
		
		FileWriter fw;
		try {
			fw = new FileWriter(new File("output/hi.dat"));
			for(String s : words){
				fw.write(s + "\n");
			}
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}

}
