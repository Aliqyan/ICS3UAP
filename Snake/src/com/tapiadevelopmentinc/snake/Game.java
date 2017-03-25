package com.tapiadevelopmentinc.snake;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JLabel;



public class Game extends Canvas implements Runnable {

	
	private static final long serialVersionUID = 6503812276980334303L;
	private static boolean running = false;
	private static Thread thread;
	public static final int WIDTH = 640, HEIGHT = 502;
	public static int adjuster = 0;
	private Menu menu;
	private Handler handler;
	
	public enum STATE {
		Menu,
		Help,
		Game,
		End
	};
	
	public static STATE gameState = STATE.Menu;
	
	public void JFrameAdjuster(){
		if(OSFinder.isMac()){
			adjuster = 22;
		}else if(OSFinder.isWindows()){
			adjuster = 22;
		}
	} 
	public static void main(String[] args) {
		System.out.println(System.getProperty("os.name"));
		new Game();
	}
	public Game(){
		handler = new Handler();
		menu = new Menu(this, handler);

		this.addKeyListener(new KeyInput(handler));
		this.addMouseListener(menu);
		new Window("Snake!", WIDTH, HEIGHT, this);
		if(gameState == STATE.Game){
			loadGame();
		}
		


	}
	public void loadGame(){
		handler.addObject(new Snake( (int)((WIDTH/2 - 20)/20) *20 , (int)((HEIGHT/2 - 20)/20) * 20, ID.Snake, handler));
		
		int foodX = (int)((Math.random() * WIDTH)/20) *20;
		int foodY = (int)((Math.random() * HEIGHT)/20) *20;
		foodX = Game.clamp(foodX, 0, Game.WIDTH - 20);
		foodY = Game.clamp(foodY, 0, Game.HEIGHT - 42);;
		handler.addObject(new Food( foodX , foodY, ID.Food, handler));
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
		
		

		if(gameState == STATE.Game){
			Font currentFont = g.getFont();
			int fontSize = (int) (currentFont.getSize() *2F);
			Font newFont = new Font("Courier New", 1, fontSize);
			g.setFont(newFont);
			g.setColor(Color.white);
			g.drawString("Score: " + Snake.snakeSize, 20, 35);
			handler.render(g);
			
		}else if(gameState == STATE.Menu ||gameState == STATE.Help || gameState == STATE.End){
			menu.render(g);
		}
		
		

		//hud.render(g);
		bs.show();		

		g.dispose();
	}
	private void tick() {
		if(gameState == STATE.Game){
			handler.tick();
		}else if(gameState == STATE.Menu || gameState == STATE.End){
			menu.tick();
		}
		
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
