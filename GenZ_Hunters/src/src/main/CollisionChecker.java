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
	public int checkObject(Entity entity,boolean player) {
		int index = 999;
		
		for (int i = 0; i < gp.obj.length; i++) {
			if (gp.obj[i]!=null) {
				//Get entity,s solid area position
				entity.solidArea.x = (int) (entity.worldx + entity.solidArea.x);
				entity.solidArea.y = (int) (entity.worldy + entity.solidArea.y);
				
				//Get the object's solid area position
				gp.obj[i].solidArea.x = gp.obj[i].worldx + gp.obj[i].solidArea.x;
				gp.obj[i].solidArea.y = gp.obj[i].worldy + gp.obj[i].solidArea.y;
				
				switch (entity.direction) {
				case "up":
					entity.solidArea.y -= entity.speed;
					if (entity.solidArea.intersects(gp.obj[i].solidArea)) {
						if (gp.obj[i].collision == true) {
							entity.collisionOn = true;
						}
						if (player == true) {
							index = i;
						}
					}
					break;
				case "down":
					entity.solidArea.y += entity.speed;
					if (entity.solidArea.intersects(gp.obj[i].solidArea)) {
						if (gp.obj[i].collision == true) {
							entity.collisionOn = true;
						}
						if (player == true) {
							index = i;
						}
					}
					break;

				case "left":
					entity.solidArea.x -= entity.speed;
					if (entity.solidArea.intersects(gp.obj[i].solidArea)) {
						if (gp.obj[i].collision == true) {
							entity.collisionOn = true;
						}
						if (player == true) {
							index = i;
						}
					}
					break;

				case "right":
					entity.solidArea.x += entity.speed;
					if (entity.solidArea.intersects(gp.obj[i].solidArea)) {
						if (gp.obj[i].collision == true) {
							entity.collisionOn = true;
						}
						if (player == true) {
							index = i;
						}
					}
					break;

				
				}
				entity.solidArea.x = entity.solidAreaDefaultX;
				entity.solidArea.y = entity.solidAreaDefaultY;
				gp.obj[i].solidArea.x = gp.obj[i].solidAreaDefaultX;
				gp.obj[i].solidArea.y = gp.obj[i].solidAreaDefaultY;
			}
		}
		
		return index;
		
	}
}
