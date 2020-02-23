package breakingBricks;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Ball {
	
	//�����
	//������
	final static int DIAMETER = 20;
	
	//�����
	final static Color BALL_COLOR = Color.RED;
	
	//�������������
	private int positionX ;
	private int positionY ;
		
	//���� ����������� ���� ����� x
	private int deltaX ;
	//���� ����������� ���� ����� y
	private int deltaY ;

	Ball(int positionX,int positionY,int deltaX,int deltaY){
		this.positionX = positionX;
		this.positionY = positionY;
		
		this.deltaX = deltaX;
		this.deltaY = deltaY;
		
	}
	
	public int getPositionX(){return positionX;}
	public int getPositionY(){return positionY;}
	
	public void setPositionX(int positionX) {this.positionX = positionX;}
	public void setPositionY(int positionY) {this.positionY = positionY;}
	
	int getDeltaX(){return deltaX;}
	int getDeltaY(){return deltaY;}
	
	void setDeltaX(int deltaX){this.deltaX = deltaX;}
	void setDeltaY(int deltaY){this.deltaY = deltaY;}
	
	
	public void drawBall(Graphics g){
		g.setColor(BALL_COLOR);
		g.fillOval(positionX, positionY, DIAMETER, DIAMETER);
	}
	
	
	void move(){
		positionX+=deltaX;
		positionY-=deltaY;
	}

	
	
}
