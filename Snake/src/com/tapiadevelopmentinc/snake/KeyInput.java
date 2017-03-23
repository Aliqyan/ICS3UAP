package com.tapiadevelopmentinc.snake;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {
	private Handler handler;
	final int UP = KeyEvent.VK_W, DOWN = KeyEvent.VK_S, LEFT = KeyEvent.VK_A, RIGHT = KeyEvent.VK_D;
	boolean horizontal = false, vertical = false;
	int currKey = 0;
	int prevKey = 0;
	
	public KeyInput(Handler handler) {
		this.handler = handler;
	}
	
	public void keyPressed(KeyEvent e){
		int currKey = e.getKeyCode();
		System.out.println(currKey);
		
			GameObject tempObject = handler.object.get(0);
			if(tempObject.getID() == ID.Snake){
				//key events for player 1
				if(currKey == UP && !vertical){
					System.out.println("up");
					tempObject.setVert(1);
					tempObject.setHoriz(0);

					vertical = true;
					horizontal = false;
				}
				if(currKey == DOWN && !vertical){
					System.out.println("down");
					tempObject.setVert(2);
					tempObject.setHoriz(0);

					vertical = true;
					horizontal = false;
				}
				if(currKey == RIGHT && !horizontal){
					System.out.println("right");
					tempObject.setVert(0);
					tempObject.setHoriz(2);

					horizontal = true;
					vertical = false;

				}
				if(currKey == LEFT && !horizontal){
					System.out.println("left");
					tempObject.setVert(0);
					tempObject.setHoriz(1);

					horizontal = true;
					vertical = false;

				}

			}
		
		
		if(currKey == KeyEvent.VK_ESCAPE) System.exit(1);
		prevKey = currKey;
	}
	/*
	public void keyReleased(KeyEvent e){
		int key = e.getKeyCode();
		System.out.println(key);
		for(int i = 0; i < handler.object.size(); i++){
			GameObject tempObject = handler.object.get(i);
			if(tempObject.getID() == ID.Snake){
				//key events for player 1
				if(key == KeyEvent.VK_W) tempObject.setVelY(0);
				if(key == KeyEvent.VK_S) tempObject.setVelY(0);
				if(key == KeyEvent.VK_D) tempObject.setVelX(0);
				if(key == KeyEvent.VK_A) tempObject.setVelX(0);
			}
			
		}
	}
	*/
}
