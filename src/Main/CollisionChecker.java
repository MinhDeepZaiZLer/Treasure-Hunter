package Main;

import entity.Entity;

public class CollisionChecker {
	
	GamePanel gp;
	public CollisionChecker(GamePanel gp) {
		this.gp=gp;
	}
	
	public void checkTile(Entity entity) {
	    int eLeftX = entity.worldx + entity.solidArea.x;
	    int eRightX = entity.worldx + entity.solidArea.x + entity.solidArea.width;
	    int eTopY = entity.worldy + entity.solidArea.y;
	    int eBottomY = entity.worldy + entity.solidArea.y + entity.solidArea.height;

	    int entityLeftCol = eLeftX / gp.tileSize;
	    int entityRightCol = eRightX / gp.tileSize;
	    int entityTopRow = eTopY / gp.tileSize;
	    int entityBottomRow = eBottomY / gp.tileSize;

	    int tileNum1, tileNum2, tileNum3, tileNum4;

	    switch (entity.direction) {
	        case "up":
	            entityTopRow = (eTopY - entity.speed) / gp.tileSize;
	            tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
	            tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
	            if (gp.tileM.Tile[tileNum1].collision || gp.tileM.Tile[tileNum2].collision) {
	                entity.collisionON = true;
	            }
	            break;
	        case "down":
	            entityBottomRow = (eBottomY + entity.speed) / gp.tileSize;
	            tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
	            tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
	            if (gp.tileM.Tile[tileNum1].collision || gp.tileM.Tile[tileNum2].collision) {
	                entity.collisionON = true;
	            }
	            break;
	        case "left":
	            entityLeftCol = (eLeftX - entity.speed) / gp.tileSize;
	            tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
	            tileNum2 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
	            if (gp.tileM.Tile[tileNum1].collision || gp.tileM.Tile[tileNum2].collision) {
	                entity.collisionON = true;
	            }
	            break;
	        case "right":
	            entityRightCol = (eRightX + entity.speed) / gp.tileSize;
	            tileNum1 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
	            tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
	            if (gp.tileM.Tile[tileNum1].collision || gp.tileM.Tile[tileNum2].collision) {
	                entity.collisionON = true;
	            }
	            break;
	    }
	}
	public int checkObject(Entity entity, boolean player) {
		
		int index = 999;
		for (int i=0; i < gp.obj.length;i++) {
			
			if (gp.obj[i] != null) {
				
				// Get entity's solid area position
				entity.solidArea.x= entity.worldx+entity.solidArea.x;
				entity.solidArea.y= entity.worldy+entity.solidArea.y;
				
				
				// Get the obj's solid area position
				gp.obj[i].solidArea.x=gp.obj[i].worldX+ gp.obj[i].solidArea.x;
				gp.obj[i].solidArea.y=gp.obj[i].worldY+ gp.obj[i].solidArea.y;
				switch (entity.direction) {
				case "up":
					entity.solidArea.y-=entity.speed;
					if (entity.solidArea.intersects(gp.obj[i].solidArea)) {
						if (gp.obj[i].collision) {
							entity.collisionON=true;
						}
						if (player) {
							index=i;
						}
					}
					break;
				case "down":
					entity.solidArea.y+=entity.speed;
					if (entity.solidArea.intersects(gp.obj[i].solidArea)) {
						if (gp.obj[i].collision) {
							entity.collisionON=true;
						}
						if (player) {
							index=i;
						}
						}
					break;
				case "left":
					entity.solidArea.x-=entity.speed;
					if (entity.solidArea.intersects(gp.obj[i].solidArea)) {
						if (gp.obj[i].collision) {
							entity.collisionON=true;
						}
						if (player) {
							index=i;
						}
						}
					break;
				case "right":
					entity.solidArea.x+=entity.speed;
					if (entity.solidArea.intersects(gp.obj[i].solidArea)) {
						if (gp.obj[i].collision) {
							entity.collisionON=true;
						}
						if (player) {
							index=i;
						}
						}
					break;
				
				}
				entity.solidArea.x=entity.solidAreaDefaultX;
				entity.solidArea.y=entity.solidAreaDefaultY;
				gp.obj[i].solidArea.x=gp.obj[i].solidAreaDefaultX;
				gp.obj[i].solidArea.y=gp.obj[i].solidAreaDefaultY;
			}
			
		}
		
		
		return index;
	}
}




