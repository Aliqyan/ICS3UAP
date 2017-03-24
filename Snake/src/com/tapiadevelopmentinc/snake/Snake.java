package com.tapiadevelopmentinc.snake;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Random;



public class Snake extends GameObject {

	Random r = new Random();
	Handler handler;
	int velX = 0, velY = 0;
	int snakeSize = 1;
	ArrayList<Integer> positionX = new ArrayList<Integer>();
	ArrayList<Integer> positionY = new ArrayList<Integer>();
	int dir = 0;


	public Snake(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		


		this.handler = handler;


	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, 20, 20);
	}

	public void tick() {
		
		//make sure you can move into intended spots only
		//up
		if (choiceVert == 1 && x % 20 == 0) {
			velY = -5;
			velX = 0;
			dir = 0;
		} 
		//down
		else if (choiceVert == 2 && x % 20 == 0) {
			velY = 5;
			velX = 0;
			dir = 1;
		}
		//left
		if (choiceHoriz == 1 && y % 20 == 0) {
			velX = -5;
			velY = 0;
			dir = 2;
		} 
		//right
		else if (choiceHoriz == 2 && y % 20 == 0) {
			velX = 5;
			velY = 0;
			dir = 3;
		}
		
		x += velX;
		y += velY;
		//note adjust these values for the window size, chosen by pixels in window
		x = Game.clamp(x, 0, Game.WIDTH - 20);
		y = Game.clamp(y, 0, Game.HEIGHT - 42);
		
			positionX.add(0, x);
			positionY.add(0, y);
			//System.out.println(positionX);
			//System.out.println(positionY);
			//System.out.println();
		
		if(positionX.size() > 100){
			positionX.subList(100, positionX.size()).clear();
			positionY.subList(100, positionY.size()).clear();

		}
		collision();
		if(snakeCollision()){
			System.out.println("You lose!");
			Game.stop();
		}

	}
	private void collision(){
		for(int i = 0; i < handler.object.size();i++){
			GameObject tempObject = handler.object.get(i);

			if(tempObject.getID() == ID.Food){ // TEMP OBJ IS ENEMY
				//collision  code
				if(getBounds().intersects(tempObject.getBounds())){
					Food.x = (int)((Math.random() * Game.WIDTH)/20) *20;
					Food.y = (int)((Math.random() * Game.HEIGHT)/20) *20;
					Food.x = Game.clamp(Food.x, 0, Game.WIDTH - 20);
					Food.y = Game.clamp(Food.y, 0, Game.HEIGHT - 42);
					System.out.println( Food.x + " , " + Food.y);
					snakeSize++;
					//placement();
					//handler.addObject(new SnakeBody( positionX.get(1), positionY.get(1), ID.SnakeBody, handler));
					//System.out.println(snakeSize);
				}
				
			}
		}
	}
	
	//collision of snake head and body
	private boolean snakeCollision() {
		for(int i = 4; i < (snakeSize-1)*4; i+=4){
			if(x == (int)positionX.get(i) && y == (int)positionY.get(i)){
				return true;
			}
		}
		return false;
	}
	/*
	private void placement() {
		positionX.add(positionX.get(0));
		positionY.add(positionY.get(0));

		if(velY == -5){
			positionY.set(1,positionY.get(0)-20);
		}else if(velY == 5){
			positionY.set(1,positionY.get(0)+20);
		}else if(velX == -5){
			positionX.set(1,positionX.get(0)+20);
		}else if(velX == 5){
			positionX.set(1,positionX.get(0)-20);
		}
		
	}
	 */
	public void render(Graphics g) {
		// UP, DOWN, LEfT, RIGHT
		// x,y ordered
		int[][] eyesPosition1 = {{3,5},{3,12}, {5,3}, {12, 3}};
		int[][] eyesPosition2 = {{14,5},{14,12}, {5, 14}, {12, 14}};

		
		for(int i = 1; i< snakeSize; i++){
			g.setColor(Color.white);
			g.fillRect(positionX.get(4*i), positionY.get(4*i), 20, 20);

			g.setColor(Color.green);
			g.fillRect(positionX.get(4*i) + 1 , positionY.get(4*i) + 1 , 18, 18);



		}
		g.setColor(Color.white);
		g.fillRect(x, y, 20, 20);
		
		g.setColor(Color.green);
		g.fillRect(x+1, y+1, 18, 18);
		
		g.setColor(Color.black);
		g.fillRect(x+eyesPosition1[dir][0], y+eyesPosition1[dir][1], 3, 3);
		
		g.setColor(Color.black);
		g.fillRect(x+eyesPosition2[dir][0], y+eyesPosition2[dir][1], 3, 3);

	}

}
