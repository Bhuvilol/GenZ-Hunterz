package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable{
	final int originalTileSize =16;
	final int scale = 3;
	
	final int tileSize = originalTileSize*scale; //48 x 48
	final int maxScreenCol = 16;
	final int maxScreenRow = 12;
	
	final int screenWidth = tileSize*maxScreenCol; // (48*16 = 768)
	final int screenHeight = tileSize*maxScreenRow; // (48*12 = 576
	
	//FPS
	int FPS = 60;
	
	KeyHandler keyH = new KeyHandler();
	Thread gameThread ;
	
	
	//Set players default position
	int playerX = 100;
	int playerY = 100;
	int playerSpeed = 4;
	
	public GamePanel(){
		this.setPreferredSize(new Dimension(screenWidth,screenHeight));
		this.setBackground(Color.BLACK);
		this.setDoubleBuffered(true);
		this.addKeyListener(keyH);
		this.setFocusable(true);
	}
	
	public void startGameThread() {
		gameThread = new Thread(this);
		gameThread.start();
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (gameThread != null) {

			//UPDATE :update information such as character position
			update();
			
			//DRAW : draw the screen with the updated information
			repaint();
		}
	}
	public void update() {
		if (keyH.upPressed == true) {
			playerY -= playerSpeed;
		}
		if (keyH.downPressed == true) {
			playerY += playerSpeed;
		}
		if (keyH.leftPressed == true) {
			playerX -= playerSpeed;
		}
		if (keyH.rightPressed == true) {
			playerX += playerSpeed;
		}
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D)g;
		
		g2.setColor(Color.WHITE);
		
		g2.fillRect(playerX, playerY, tileSize, tileSize);
		
		g2.dispose();
		
	}
	
}
