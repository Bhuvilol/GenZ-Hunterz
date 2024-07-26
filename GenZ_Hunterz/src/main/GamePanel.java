package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable{
	final int originalTileSize =16;
	final int scale = 3;
	
	final int tileSize = originalTileSize*scale; //48 x 48
	final int maxScreenCol = 16;
	final int maxScreenRow = 12;
	
	final int screenWidth = tileSize*maxScreenCol; // (48*16 = 768)
	final int screenHeight = tileSize*maxScreenRow; // (48*12 = 576
	
	Thread gameThread ;
	
	GamePanel(){
		this.setPreferredSize(new Dimension(screenWidth,screenHeight));
		this.setBackground(Color.BLACK);
		this.setDoubleBuffered(true);
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
		
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
	}
	
}
