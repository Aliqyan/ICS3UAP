package com.tapiadevelopmentinc.snake;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JLabel;



public class Game extends Canvas implements Runnable {

	
	private static final long serialVersionUID = 6503812276980334303L;
	private static boolean running = false;
	private static Thread thread;
	public static final int WIDTH = 600, HEIGHT = 422;
	
	private Handler handler;
	public static void main(String[] args) {
		new Game();
	}
	public Game(){
		handler = new Handler();
		this.addKeyListener(new KeyInput(handler));

		new Window("Snake!", WIDTH, HEIGHT, this);
		handler.addObject(new Snake( (int)((WIDTH/2 - 20)/20) *20 , (int)((HEIGHT/2 - 20)/20) * 20, ID.Snake, handler));
		int foodX = (int)((Math.random() * WIDTH)/20) *20;
		int foodY = (int)((Math.random() * HEIGHT)/20) *20;
		foodX = Game.clamp(foodX, 0, Game.WIDTH - 20);
		foodY = Game.clamp(foodY, 0, Game.HEIGHT - 42);;
		handler.addObject(new Food( (int)((Math.random() * WIDTH)/20) *20 , (int)((Math.random() * HEIGHT)/20) *20, ID.Food, handler));


	}
	@Override
	public void run() {
		 this.requestFocus();
		 long lastTime = System.nanoTime();
	        double amountOfTicks = 60.0;
	        double ns = 1000000000 / amountOfTicks;
	        double delta = 0;
	        long timer = System.currentTimeMillis();
	        int frames = 0;
	        while(running){
	                    long now = System.nanoTime();
	                    delta += (now - lastTime) / ns;
	                    lastTime = now;
	                    while(delta >=1){
	                    	tick();
	                        delta--;
	                    }
	                    if(running){
	                      	render();
	                    }
	                    frames++;
	                          
	                    if(System.currentTimeMillis() - timer > 1000){
	                      	timer += 1000;
	                        //System.out.println("FPS: "+ frames);
	                        frames = 0;
	                    }
	        }
	        stop();
		
	}
	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
		running = true;		
	}
	
	public synchronized static void stop() {
		try{
			thread.join();
			running = false;
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null){
			this.createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		
		
		handler.render(g);
		

		//hud.render(g);
		bs.show();		

		g.dispose();
	}
	private void tick() {
		handler.tick();
		
	}
	public static int clamp(int var, int min, int max){
		if(var > max){
			return var = min;
		}else if(var < min){
			return var = max;
		}else{
			return var;
		}
	}

}
