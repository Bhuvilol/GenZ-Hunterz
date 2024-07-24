package main;

import entity.Entity;

public class CollisionChecker {
	GamePanel gp;
	public CollisionChecker(GamePanel gp) {
		this.gp = gp;
	}
	public void checkTile(Entity entity) {
		int entityLeftWorldX = (int) (entity.worldx + entity.solidArea.x);
		int entityRightWorldX = (int) (entity.worldx + entity.solidArea.x + entity.solidArea.width);
		int entityTopWorldY = (int) (entity.worldy + entity.solidArea.y);
		int entityBottomWorldY = (int) (entity.worldy + entity.solidArea.y + entity.solidArea.width);
		
		int entityLeftCol = (int) (entityLeftWorldX/gp.tileSize);
		int entityRightCol = (int) (entityRightWorldX/gp.tileSize);
		int entityTopRow = (int) (entityTopWorldY/gp.tileSize);
		int entityBottomRow = (int) (entityBottomWorldY/gp.tileSize);
		
		int tileNum1, tileNum2;
		
		switch (entity.direction) {
		case "up":
			entityTopRow = (int) ((entityTopWorldY - entity.speed)/gp.tileSize);
			tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
			tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
			if (gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true) {
				entity.collisionOn = true;
			}
//			tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
//			tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
//			
//			
			
			break;
		case "down":
			entityBottomRow = (int) ((entityBottomWorldY + entity.speed)/gp.tileSize);
			tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
			tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
			if (gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true) {
				entity.collisionOn = true;
			}
			break;
		case "left":
			entityLeftCol= (int) ((entityLeftWorldX - entity.speed)/gp.tileSize);
			tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
			tileNum2 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
			if (gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true) {
				entity.collisionOn = true;
			}
			break;
		case "right":
			entityRightCol = (int) ((entityRightWorldX + entity.speed)/gp.tileSize);
			tileNum1 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
			tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
			if (gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true) {
				entity.collisionOn = true;
			}
			break;
		default:
			break;
		}
				
	}
}
