package com.tapiadevelopmentinc.snake;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class Window extends Canvas{
	

	private static final long serialVersionUID = -4862769661114639276L;
	JFrame myFrame;
	private JLayeredPane myPanes;

	public Window(String title, int width, int height, Game game){
		//myPanes = new JLayeredPane();
		myFrame = new JFrame(title);
		
	
		myFrame.setSize(width, height);
		myFrame.setResizable(false);
		myFrame.setLocationRelativeTo(null);
		
        myFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		
		myFrame.add(game);
		
		myFrame.setVisible(true);
		game.start();
	} 


}
