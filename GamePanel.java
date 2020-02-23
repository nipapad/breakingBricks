package breakingBricks;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener {
	
	//διαστάσεις του παραθύρου
	//Dimension JFrameDimensions;
	final static int WIDTH = 1200;
	final static int HEIGHT = 600;
	
	
	
	private BufferedImage image;
    private Graphics2D bufferedGraphics;
	
	private Ball ball;
	private Paddle paddle;
	
	
	Timer timer;
	
	public GamePanel(){
		super();
        /*
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
        image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        bufferedGraphics = image.createGraphics();
		*/
		paddle = new Paddle(WIDTH/2);
		ball = new Ball(100,HEIGHT-100, 5, 5);
		
		/*addKeyListener(paddle);*/
		timer = new Timer(50, this);
		timer.start();
		//requestFocus();
	}
	
	
	public void paintComponent(Graphics g) {
	      super.paintComponent(g);
	      
	      //bufferedGraphics.clearRect(0, 0, WIDTH, HEIGHT);
	      //bufferedGraphics.setColor(Color.WHITE);
	      //bufferedGraphics.fillRect(0, 0, WIDTH, HEIGHT);
	      this.setBackground(Color.cyan);
	      ball.drawBall(g);
	      paddle.drawPaddle(g);
	      //drawing messages sent to g
	      
	      
	      //Timer timer = new Timer(10, this);
	      //g.setColor(Color.BLACK);
	      //g.drawString(timer., JPanelWidth-200, 100);
	      
	    }
	/*
	@Override
	public void keyTyped(KeyEvent e){}
	
	@Override
	public void keyPressed(KeyEvent e){
		
		if (e.getKeyCode()==KeyEvent.VK_RIGHT){
			moveRight();
			
		}
		
		if (e.getKeyCode()==KeyEvent.VK_LEFT){
			moveLeft();
			
		}
		
		//if (e.getKeyCode()==KeyEvent.VK_ENTER)
		//	startGame();
		
		repaint();
	}
	
	void moveRight(){
		if (paddle.getPositionX()<GamePanel.WIDTH) 
			paddle.setPositionX(paddle.getPositionX()+Paddle.STEP);
		
		else paddle.setPositionX(GamePanel.WIDTH);
	}
	
	void moveLeft(){
		if (paddle.getPositionX()>0)
			paddle.setPositionX(paddle.getPositionX()-Paddle.STEP);
		
		else paddle.setPositionX(0);
	}
	


	@Override
	public void keyReleased(KeyEvent e){}
	*/
	private void checkCollisions(){
		if (ball.getPositionY()==0 || ball.getPositionY()==HEIGHT-2*Ball.DIAMETER){
			ball.setDeltaY(-ball.getDeltaY());
		}
				
		if (ball.getPositionX()==0 || ball.getPositionX()==WIDTH-Ball.DIAMETER){
			ball.setDeltaX(-ball.getDeltaX());
		}
		
	}
	
	
	
	
	private void startGame() {
		//addKeyListener(this);
		timer.start();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		checkCollisions();
		ball.move();
		repaint();
	}

	public static void main(String[] args){
		JFrame frame = new JFrame();
        GamePanel c = new GamePanel();
        frame.setSize(WIDTH, HEIGHT);
        frame.add(c);
        //frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}
