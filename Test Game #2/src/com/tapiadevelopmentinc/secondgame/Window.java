package com.tapiadevelopmentinc.secondgame;

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
		
		
		JLabel highscore = new JLabel("Highscore", JLabel.CENTER);
		
		JPanel myPanel = new JPanel(){
			public void paintComponent(Graphics g){
				g.setColor(Color.red);
				g.fillRect(0, 0, 200, 200);
			}
		};
		JPanel myPanel2 = new JPanel(){
			public void paintComponent(Graphics g){
				g.setColor(Color.green);
				g.fillRect(0, 0, 200, 200);
			}
		};
		
		JPanel theGame = new JPanel();
		theGame.add(game);
		
		
		//myPanes.add(myPanel, new Integer(0));
		//myPanes.add(highscore, new Integer(1));

		myFrame.setSize(width, height);
		myFrame.setResizable(false);
		myFrame.setLocationRelativeTo(null);
		
        myFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		/*
		JPanel myPanel = new JPanel();
		JLabel highscore = new JLabel("Highscore", JLabel.CENTER);
		highscore.setForeground(Color.white);
		myPanel.add(highscore);
		myFrame.add(myPanel);
		*/
		
		myFrame.add(theGame);
		//myFrame.add(myPanel);
		
		myFrame.setVisible(true);
		game.start();
	} 


}
