package Main;

import object.KeyChest;
import object.OBJ_BOOTS;
import object.OBJ_CHEST;
import object.OBJ_DOOR;
import object.OBJ_KEY;

public class AssetSetter {
	
	GamePanel gp;
	
	public AssetSetter(GamePanel gp) {
		this.gp=gp;
		
	}
	public void setObject() {
		
		gp.obj[0] = new OBJ_KEY();
		gp.obj[0].worldX = 30* gp.tileSize;
		gp.obj[0].worldY = 16* gp.tileSize;
		
		gp.obj[1] = new OBJ_KEY();
		gp.obj[1].worldX = 8* gp.tileSize;
		gp.obj[1].worldY = 6* gp.tileSize;
		
		gp.obj[2] = new OBJ_DOOR();
		gp.obj[2].worldX = 36* gp.tileSize;
		gp.obj[2].worldY = 25* gp.tileSize;
		
		gp.obj[3] = new OBJ_CHEST();
		gp.obj[3].worldX = 37* gp.tileSize;
		gp.obj[3].worldY = 22* gp.tileSize;
		
		gp.obj[4] = new OBJ_BOOTS();
		gp.obj[4].worldX = 22* gp.tileSize;
		gp.obj[4].worldY = 25* gp.tileSize;
		
		gp.obj[5] = new KeyChest();
		gp.obj[5].worldX = 29* gp.tileSize;
		gp.obj[5].worldY = 42* gp.tileSize;
		
		gp.obj[6] = new OBJ_KEY();
		gp.obj[6].worldX = 22* gp.tileSize;
		gp.obj[6].worldY = 34* gp.tileSize;
		
		gp.obj[7] = new OBJ_DOOR();
		gp.obj[7].worldX = 27* gp.tileSize;
		gp.obj[7].worldY = 17* gp.tileSize;
		
		gp.obj[8] = new OBJ_KEY();
		gp.obj[8].worldX = 16* gp.tileSize;
		gp.obj[8].worldY = 15* gp.tileSize;
		
		gp.obj[9] = new OBJ_DOOR();
		gp.obj[9].worldX = 17* gp.tileSize;
		gp.obj[9].worldY = 28* gp.tileSize;
		
		gp.obj[10] = new OBJ_DOOR();
		gp.obj[10].worldX = 17* gp.tileSize;
		gp.obj[10].worldY = 17* gp.tileSize;
	}
}
