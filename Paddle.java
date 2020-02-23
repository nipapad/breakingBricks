package breakingBricks;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Paddle {
	//διαστάσεις της μπάρας
	final static int PADDLE_WIDTH = 140 ;
	final static int PADDLE_HEIGHT = 20 ;
		
	//χρώμα της μπάρας
	final static Color PADDLE_COLOR = Color.ORANGE;

	//το βήμα μετακίνησης της μπάρας
	final static int STEP = 10 ;
	
	private int positionX;
	final static int POSITION_Y = GamePanel.HEIGHT - 100;
	
	Paddle(int positionX){
		this.positionX = positionX;
		//addKeyListener(this);
		//this.POSITION_Y = positionY;
	}
	
	void drawPaddle(Graphics g){
		g.setColor(PADDLE_COLOR);
		g.fillRect(positionX, POSITION_Y, PADDLE_WIDTH, PADDLE_HEIGHT);
	}
	
	
	int getPositionX(){return positionX;}
	
	void setPositionX(int positionX){this.positionX=positionX;}
	
	
	void moveRight(){
		if (positionX<GamePanel.WIDTH) positionX += STEP;
		
		else positionX=GamePanel.WIDTH;
	}
	
	void moveLeft(){
		if (positionX<0) positionX=0;
		
		else positionX -= STEP;
	}

	
	
}
