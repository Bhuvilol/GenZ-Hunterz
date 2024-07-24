package entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.KeyHandler;

public class Player extends Entity{
	GamePanel gp;
	KeyHandler keyH;
	
	public final int screenx;
	public final int screeny;
	
	public Player(GamePanel gp , KeyHandler keyH) {
		this.gp = gp;
		this.keyH=keyH;
		
		screenx = gp.screenWidth/2 - (gp.tileSize/2);
		screeny = gp.screenHeight/2 - (gp.tileSize/2);
		
		solidArea = new Rectangle();
		solidArea.x = 20;
		solidArea.y = 26;
		solidArea.width = 16;
		solidArea.height = 10;
		
		setDefaultValues();
		getPlayerImage();
	}
	public void setDefaultValues() {
		worldx=gp.tileSize*23;
		worldy=gp.tileSize*21;
		speed = 4;
		speed = gp.worldWidth/600;
		direction = "down";
	}
	public void getPlayerImage() {
		try {
			up1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_up_1.png"));
			up2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_up_2.png"));
			down1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_down_1.png"));
			down2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_down_2.png"));
			left1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_left_1.png"));
			left2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_left_2.png"));
			right1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_right_1.png"));
			right2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_right_2.png"));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void update() {
		if (keyH.upPressed == true || keyH.downPressed==true || keyH.leftPressed==true || keyH.rightPressed==true) {
			if (keyH.upPressed) {
				direction = "up";
			}else if (keyH.downPressed) {
				direction = "down";
			}else if (keyH.leftPressed) {
				direction = "left";
			}else if (keyH.rightPressed) {
				direction = "right";
			}
			//CHECK TILE COLLISION
			collisionOn = false;
			gp.cChecker.checkTile(this);
			
			
			//IF COLLISION IS FALSE, PLAYER CAN MOVE
			if (collisionOn == false) {
				switch (direction) {
				case "up":worldy-=speed;break;
				case "down":worldy+=speed;break;
				case "left":worldx-=speed;break;
				case "right":worldx+=speed;	break;

				default:
					break;
				}
			}
			spriteCounter++;
			if (spriteCounter>15) {
				if (spriteNum == 1) {
					spriteNum=2;
				}else if (spriteNum==2) {
					spriteNum=1;
				}
				spriteCounter=1;
			}
		}

	}
	public void draw(Graphics2D g2) {
	
		BufferedImage image = null;
		
		switch (direction) {
		case "up":
			if (spriteNum == 1) {
				image = up1;
			}
			if (spriteNum == 2) {
				image = up2;
			}
			break;
		case "down":
			if (spriteNum == 1) {
				image = down1;
			}
			if (spriteNum == 2) {
				image = down2;
			}
			break;
		case "left":
			if (spriteNum == 1) {
				image = left1;
			}
			if (spriteNum == 2) {
				image = left2;
			}
			break;

		case "right":
			if (spriteNum == 1) {
				image = right1;
			}
			if (spriteNum == 2) {
				image = right2;
			}
			break;

		}
		g2.drawImage(image, screenx, screeny, gp.tileSize, gp.tileSize, null );
	}
}
