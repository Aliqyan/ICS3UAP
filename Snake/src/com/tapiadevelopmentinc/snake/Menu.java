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
		if(game.gameState == STATE.End && mouseOver(mX, mY, (game.width-game.adjusterX-300)/4, 600, 300, 96) ){
			KeyInput.currKey = 0;
			Snake.snakeSize = 1;
			handler.object.clear();
			game.loadGame();
			game.gameState = STATE.Game;
			
				
			return;
		}
		// back button for end
		if(game.gameState == STATE.End && mouseOver(mX, mY, (game.width-game.adjusterX-300)/4 * 3, 600, 300, 96) ){
			System.exit(1);
		}
			
		//back button for help
		if(game.gameState == STATE.Help && mouseOver(mX, mY, 210, 350,200,64)){
			game.gameState = STATE.Menu;
			return;
		}
		if(game.gameState == STATE.Menu){
			//play button
			if(mouseOver(mX, mY, (game.width-game.adjusterX-300)/2, 300, 300, 96)){
				game.gameState = STATE.Game;
				game.loadGame();		
			}
		
			//Help button
			if(mouseOver(mX, mY, (game.width-game.adjusterX-300)/2, 450, 300, 96)){
				game.gameState = STATE.Help;
			}
			//quit button
			if(mouseOver(mX, mY, (game.width-game.adjusterX-300)/2, 600, 300, 96)){
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
		Font font1 = new Font("arial", 1, 80);

		Font font2 = new Font("arial", 1, 40);
		Font font3 = new Font("arial", 1, 20);
		if(game.gameState == STATE.Menu){
			
		

		g.setFont(font1);
		g.setColor(Color.white);
		g.drawString("Snake", (game.width-game.adjusterX)/2-120, 170);

		g.setFont(font2);
		g.drawRect((game.width-game.adjusterX-300)/2, 300, 300, 96);
		g.drawString("Play", (game.width-game.adjusterX)/2-40, 360);


		g.drawRect((game.width-game.adjusterX-300)/2, 450, 300, 96);
		g.drawString("Help", (game.width-game.adjusterX)/2-40, 510);

		
		g.drawRect((game.width-game.adjusterX-300)/2, 600, 300, 96);
		g.drawString("Quit", (game.width-game.adjusterX)/2-40, 660);
		}else if(game.gameState == STATE.Help){
			

			g.setFont(font1);
			g.setColor(Color.white);
			g.drawString("Help", 240, 70);
			g.setFont(font3);
			
			g.drawString("I'll do this later!!!", 50, 200);
			g.setFont(font2);

			g.drawRect((game.width-game.adjusterX-300)/2, 600, 300, 96);
			g.drawString("Back", (game.width-game.adjusterX)/2-40, 660);
		}
		else if(game.gameState == STATE.End){
			

			g.setFont(font1);
			g.setColor(Color.white);
			g.drawString("Game Over!", game.width/2-240, 70);
			g.setFont(font2);
			
			g.drawString("You lost with a score of " + Snake.snakeSize + "!", 50, 140);
			g.drawString("Yo B I'll finish this later!", 50, 190);

			g.setFont(font2);

			g.drawRect((game.width-game.adjusterX-300)/4, 600, 300, 96);
			g.drawString("Try Again", (game.width-game.adjusterX)/4 -10, 660);
			
			g.drawRect((game.width-game.adjusterX-300)/4 * 3, 600, 300, 96);
			g.drawString("Quit", (game.width-game.adjusterX)/4 *3 - 120 , 660);
		}

	}
}
