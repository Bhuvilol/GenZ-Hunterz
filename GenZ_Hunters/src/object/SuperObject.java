package object;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import main.GamePanel;

public class SuperObject {
	public BufferedImage image;
	public String name;
	public boolean collision = false;
	public int worldx , worldy;
	public Rectangle solidArea = new Rectangle(0,0,48,48);
	public int solidAreaDefaultX = 0;
	public int solidAreaDefaultY = 0;
	
	public void draw(Graphics g2,GamePanel gp) {
		
		double screenx = worldx - gp.player.worldx + gp.player.screenx;
		double screeny = worldy - gp.player.worldy + gp.player.screeny;
		
		if (worldx + gp.tileSize > gp.player.worldx - gp.player.screenx &&
			worldx - gp.tileSize < gp.player.worldx + gp.player.screenx &&
			worldy + gp.tileSize > gp.player.worldy - gp.player.screeny &&
			worldy - gp.tileSize <gp.player.worldy + gp.player.screeny) {
			
			g2.drawImage(image, (int)screenx, (int)screeny, gp.tileSize, gp.tileSize, null);
		}
	}
}
