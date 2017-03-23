package com.tapiadevelopmentinc.snake;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;



public class Snake extends GameObject {

	Random r = new Random();
	Handler handler;
	int velX = 0, velY = 0;
	int snakeSize = 1;

	public Snake(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;

	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, 20, 20);
	}

	public void tick() {
		//make sure you can move into intended spots only
		if (choiceVert == 1 && x % 20 == 0) {
			velY = -5;
			velX = 0;
		} else if (choiceVert == 2 && x % 20 == 0) {
			velY = 5;
			velX = 0;
		}

		if (choiceHoriz == 1 && y % 20 == 0) {
			velX = -5;
			velY = 0;
		} else if (choiceHoriz == 2 && y % 20 == 0) {
			velX = 5;
			velY = 0;
		}
		System.out.println(Game.HEIGHT);
		
		x += velX;
		y += velY;
		//note adjust these values for the window size, chosen by pixels in window
		x = Game.clamp(x, 0, Game.WIDTH - 20);
		y = Game.clamp(y, 0, Game.HEIGHT - 22);

		collision();
	}
	private void collision(){
		for(int i = 0; i < handler.object.size();i++){
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getID() == ID.Food){ // TEMP OBJ IS ENEMY
				//collision  code
				if(getBounds().intersects(tempObject.getBounds())){
					Food.x = (int)((Math.random() * Game.WIDTH)/20) *20;
					Food.y = (int)((Math.random() * Game.HEIGHT)/20) *20;
					snakeSize++;
					System.out.println(snakeSize);
				}
				
			}
		}
	}
	public void render(Graphics g) {
		g.setColor(Color.white);

		g.fillRect(x, y, 20, 20);
		g.setColor(Color.green);

		g.fillRect(x+1, y+1, 18, 18);
		

	}

}
