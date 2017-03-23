package com.tapiadevelopmentinc.snake;

import java.awt.Canvas;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Window extends Canvas{
	

	private static final long serialVersionUID = -4862769661114639276L;
	

	public Window(String title, int width, int height, Game game){
		JFrame myFrame = new JFrame(title);
		myFrame.setSize(width, height);
		myFrame.setResizable(false);
		myFrame.setLocationRelativeTo(null);
		myFrame.add(game);
        myFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		myFrame.setVisible(true);
		game.start();
	} 


}
