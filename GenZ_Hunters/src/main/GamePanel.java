package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

import entity.Player;
import object.SuperObject;
import tile.TileManager;

public class GamePanel extends JPanel implements Runnable{
	
	//SCREEN SETTINGS
	final int originalTileSize = 16; // 16x16 tile
	final int scale = 3;
	
	public int tileSize = originalTileSize*scale; // 16*3 = 48 tile
	public int maxScreenCol = 16;
	public int maxScreenRow = 12;
	public int screenWidth = tileSize* maxScreenCol; // 768 pixels
	public int screenHeight = tileSize* maxScreenRow; // 576 pixels
	
	//WORLD SETTINGS
	public final int maxWorldCol = 50;
	public final int maxWorldRow = 50;
	public final int worldWidth = tileSize*maxWorldCol;
	public final int worldHeight = tileSize*maxWorldRow;
	
	
	//FPS
	int FPS = 60;
	
	
	TileManager tileM = new TileManager(this);
	KeyHandler keyH = new KeyHandler(this);
	Thread gamethread;
	public CollisionChecker cChecker = new CollisionChecker(this);
	
	public AssetSetter aSetter = new AssetSetter(this);
	
	public Player player = new Player(this,keyH);
	
	public SuperObject obj[] = new SuperObject[10];
	
	
	public GamePanel() {
		this.setPreferredSize(new Dimension(screenWidth,screenHeight));
		this.setBackground(Color.BLACK);
		this.setDoubleBuffered(true);
		this.addKeyListener(keyH);
		setFocusable(true);
	}
	
	public void setupGame() {
		aSetter.setObject();
	}
	
	public void zoomInOut(int i) {
		int oldWorldWidth = tileSize * maxWorldCol;
		tileSize += i;
		int newWorldWidth = tileSize* maxWorldCol;
		
		player.speed = (double)newWorldWidth/600;
		
		double multiplier = (double)newWorldWidth/oldWorldWidth;
		
		double newPlayerWorldx = player.worldx * multiplier;
		double newPlayerWorldy = player.worldy * multiplier;
		
		player.worldx = newPlayerWorldx;
		player.worldy = newPlayerWorldy;
	}
	

	public void startGameThread() {
		gamethread = new Thread(this);
		gamethread.start();
	}
	@Override
	public void run() {
		double drawInterval = 1000000000/FPS; //0.016666 seconds
		double nextDrawTime = System.nanoTime() + drawInterval;
		while (gamethread != null) {

			//1 - UPDATE : update the information such as character position
			update();
			//2 - DRAW : draw the screen with the updated information
			repaint();
			
			try {
				double remainingTime = nextDrawTime-System.nanoTime();
				remainingTime = remainingTime/1000000;
				if (remainingTime<0) {
					remainingTime =0;
				}
				
				Thread.sleep((long)remainingTime);
				
				nextDrawTime += drawInterval;
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	public void update() {
		player.update();
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D)g;
		//TILE
		tileM.draw(g2);
		//OBJECT
		for (int i = 0; i < obj.length; i++) {
			if (obj[i]!= null) {
				obj[i].draw(g2, this);
			}
		}
		//PLAYER
		player.draw(g2);
		
		g2.dispose();
	}
}
