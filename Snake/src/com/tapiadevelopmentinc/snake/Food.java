package com.tapiadevelopmentinc.snake;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Food extends GameObject {
	Random r = new Random();
	Handler handler;
	static int x;
	static int y;
	
	@SuppressWarnings("static-access")
	public Food(int x, int y, ID id, Handler handler) {
		super(x,y, id);
		this.x = x;
		this.y = y;
		this.handler = handler;
	}

	@Override
	public void tick() {
		
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.red);

		g.fillOval(x+1, y+1, 18, 18);
		
		
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle(x, y, 20, 20);
	}

}
