package Tile;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

import Main.GamePanel;

public class TileManager {
	
	GamePanel gp;
	public tile[]  Tile;
	public int mapTileNum[][];
	
	public TileManager(GamePanel gp) {
		
		this.gp=gp;
		Tile = new tile[10];
		mapTileNum=new int[gp.maxworldcol][gp.maxworldrow];
		
		getTileImage();
		loadmap("/maps/world01.txt");
	
	}

	public void getTileImage() {
			try {
				Tile[0]=new tile();
				Tile[0].image= ImageIO.read(getClass().getResourceAsStream("/tiles/grass.png"));
				
				Tile[1]=new tile();
				Tile[1].image= ImageIO.read(getClass().getResourceAsStream("/tiles/wall.png"));
				Tile[1].collision=true;
				
				Tile[2]=new tile();
				Tile[2].image= ImageIO.read(getClass().getResourceAsStream("/tiles/water.png"));
				Tile[2].collision=true;
				
				Tile[3]=new tile();
				Tile[3].image= ImageIO.read(getClass().getResourceAsStream("/tiles/earth.png"));
				
				Tile[4]=new tile();
				Tile[4].image= ImageIO.read(getClass().getResourceAsStream("/tiles/tree.png"));
				Tile[4].collision=true;
				
				Tile[5]=new tile();
				Tile[5].image= ImageIO.read(getClass().getResourceAsStream("/tiles/sand.png"));
				
				Tile[6]=new tile();
				Tile[6].image= ImageIO.read(getClass().getResourceAsStream("/tiles/wood.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	public void loadmap(String filePath) {
		
		try {
			InputStream is= getClass().getResourceAsStream(filePath);
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			
			int col=0;
			int row=0;
			
			while(col<gp.maxworldcol && row<gp.maxworldrow) {
					String line = br.readLine();
					
					while (col< gp.maxworldcol) {
						
						String numbers[] = line.split(" ");
						
						int num = Integer.parseInt(numbers[col]);
						
						mapTileNum[col][row] = num;
						col++;
						System.out.print(col+" ");
					}
					if (col == gp.maxworldcol) {
						System.out.println();
						col=0;
						row++;
					}
			}
			br.close();
			
		} catch (Exception e) {
			
		}
	}
	public void draw(Graphics2D g2) {
	    int worldcol = 0;
	    int worldrow = 0;

	    while (worldrow < gp.maxworldrow) {
	        int tileNum = mapTileNum[worldcol][worldrow];

	        int worldX = worldcol * gp.tileSize;
	        int worldY = worldrow * gp.tileSize;
	        int screenX = worldX - gp.player.worldx + gp.player.screenX;
	        int screenY = worldY - gp.player.worldy + gp.player.screenY;

	        g2.drawImage(Tile[tileNum].image, screenX, screenY, gp.tileSize, gp.tileSize, null);

	        worldcol++;

	        if (worldcol == gp.maxworldcol) {
	            worldcol = 0;
	            worldrow++;
	        }
	    }
	}
		
	
}
