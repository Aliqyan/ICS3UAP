package com.tapiadevelopmentinc.snake;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.tapiadevelopmentinc.snake.Game.STATE;

public class Menu extends MouseAdapter{
	private Game game;
	private Handler handler;
	public Menu(Game game, Handler handler){
		this.game = game;
		this.handler = handler;
	}
	public void mousePressed(MouseEvent e){
		int mX = e.getX();
		int mY = e.getY();
	
		//try again button for end
		if(game.gameState == STATE.End && mouseOver(mX, mY, 210, 350,200,64)){
			KeyInput.currKey = 0;
			Snake.snakeSize = 1;
			handler.object.clear();
			game.loadGame();
			game.gameState = STATE.Game;
			
				
			return;
		}
			
		//back button for help
		if(game.gameState == STATE.Help && mouseOver(mX, mY, 210, 350,200,64)){
			game.gameState = STATE.Menu;
			return;
		}
		if(game.gameState == STATE.Menu){
			//play button
			if(mouseOver(mX, mY, 210,150,200,64)){
				game.gameState = STATE.Game;
				handler.addObject(new Snake( (int)((Game.WIDTH/2 - 20)/20) *20 , (int)((Game.HEIGHT/2 - 20)/20) * 20, ID.Snake, handler));
				
				int foodX = (int)((Math.random() * Game.WIDTH)/20) *20;
				int foodY = (int)((Math.random() * Game.HEIGHT)/20) *20;
				foodX = Game.clamp(foodX, 0, Game.WIDTH - 20);
				foodY = Game.clamp(foodY, 0, Game.HEIGHT - 42);;
				handler.addObject(new Food( foodX, foodY, ID.Food, handler));
		
			}
		
			//Help button
			if(mouseOver(mX, mY, 210, 250,200,64)){
				game.gameState = STATE.Help;
			}
			//quit button
			if(mouseOver(mX, mY, 210, 350,200,64)){
				System.exit(1);

			}
		}
		
	}
	public void mouseReleased(MouseEvent e){
		
	}
	public void tick(){
		
	}
	
	private boolean mouseOver(int mX, int mY, int x, int y, int width, int height){
		return (mX > x && mX < x +width && mY > y && mY < y + height);
	}
			
	
	public void render(Graphics g){
		if(game.gameState == STATE.Menu){
			
		
		Font font1 = new Font("arial", 1, 50);
		Font font2 = new Font("arial", 1, 30);

		g.setFont(font1);
		g.setColor(Color.white);
		g.drawString("Snake", 240, 70);

		g.setFont(font2);
		g.drawRect(210, 150, 200, 64);
		g.drawString("Play", 270, 190);


		g.drawRect(210, 250, 200, 64);
		g.drawString("Help", 270, 290);

		
		g.drawRect(210, 350, 200, 64);
		g.drawString("Quit", 270, 390);
		}else if(game.gameState == STATE.Help){
			Font font1 = new Font("arial", 1, 50);

			Font font2 = new Font("arial", 1, 30);
			Font font3 = new Font("arial", 1, 20);

			g.setFont(font1);
			g.setColor(Color.white);
			g.drawString("Help", 240, 70);
			g.setFont(font3);
			
			g.drawString("I'll do this later!!!", 50, 200);
			g.setFont(font2);

			g.drawRect(210, 350, 200, 64);
			g.drawString("Back", 270, 390);
		}
		else if(game.gameState == STATE.End){
			Font font1 = new Font("arial", 1, 50);

			Font font2 = new Font("arial", 1, 30);
			Font font3 = new Font("arial", 1, 20);

			g.setFont(font1);
			g.setColor(Color.white);
			g.drawString("Game Over!", 170, 70);
			g.setFont(font3);
			
			g.drawString("You lost with a score of " + Snake.snakeSize + "!", 50, 140);
			g.setFont(font2);

			g.drawRect(210, 350, 200, 64);
			g.drawString("Try Again", 240, 390);
		}

	}
}
