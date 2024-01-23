package entity;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import Main.GamePanel;
import Main.KeyHand;

public class Player extends Entity {

	GamePanel gp;
	KeyHand keyH;
	
	public final int screenX;
	public final int screenY;
	public int invK=0; //inventory
	public int invC=0;
	
	public Player(GamePanel gp, KeyHand keyH) {
		this.gp=gp;
		this.keyH=keyH;
		
		screenX=gp.screenWidth/2- (gp.tileSize/2);
		screenY=gp.screenHeight/2- (gp.tileSize/2);
		
		solidArea=new Rectangle();
		solidArea.x=8;
		solidArea.y=16;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY=solidArea.y;
		solidArea.width=32;
		solidArea.height=32;
		
		setDefaut();
		getPI();
	}
	
	public void setDefaut() {
		worldx=gp.tileSize*21;
		worldy=gp.tileSize*24;
		speed=4;
		direction="down";
	}
	public void getPI() { //getPlayerImage
		try {
			up=ImageIO.read(getClass().getResourceAsStream("/player/up.png"));
			up1=ImageIO.read(getClass().getResourceAsStream("/player/up1.png"));
			up2=ImageIO.read(getClass().getResourceAsStream("/player/up2.png"));
			down=ImageIO.read(getClass().getResourceAsStream("/player/down.png"));
			down1=ImageIO.read(getClass().getResourceAsStream("/player/down1.png"));
			down2=ImageIO.read(getClass().getResourceAsStream("/player/down2.png"));
			left=ImageIO.read(getClass().getResourceAsStream("/player/left.png"));
			left1=ImageIO.read(getClass().getResourceAsStream("/player/left1.png"));
			left2=ImageIO.read(getClass().getResourceAsStream("/player/left2.png"));
			right=ImageIO.read(getClass().getResourceAsStream("/player/right.png"));
			right1=ImageIO.read(getClass().getResourceAsStream("/player/right1.png"));
			right2=ImageIO.read(getClass().getResourceAsStream("/player/right2.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void update() {
		if (keyH.upp==true || keyH.downp==true || keyH.leftp==true || keyH.rightp==true) {
			if (keyH.upp == true ) {
				direction="up";
			
			} else if (keyH.downp==true) {
				direction="down";
			
			} else if (keyH.leftp==true) {
				direction="left";
			
			} else if (keyH.rightp==true) {
				direction="right";
			
			} 
			
			//ktra va cham
			collisionON=false;
			gp.cChecker.checkTile(this);
			//ktra obj
			int objIndex = gp.cChecker.checkObject(this, true);
			ActObj(objIndex);
			// false-> di chuyen
			if (collisionON==false) {
				switch (direction) {
				case "up":worldy-=speed; break;
				case"down":worldy+=speed; break;
				case"left":worldx-=speed; break;
				case"right":worldx+=speed; break;
				}
			}
			
			footcount++;
			if (footcount>12) {
				if (footnum==1) {
					footnum=2;
				} else footnum=1;
				footcount=0;
			}
		}
		
	
	}
	public void ActObj (int i) {
		if (i != 999) {
			
			String objName = gp.obj[i].name;
			
			switch (objName) {
			case "Key":
				gp.key++;
				gp.time=3;
				invK++;
				gp.obj[i]=null;
				System.out.println(invK);
				break;
			case "Door":
				if (invK>0) {
					invK--;
					gp.obj[i] = null;
					System.out.println(invK);
				}
				break;
			case "Chest":
				if (invC>0 && gp.key==5) {
					
					invC--;
					gp.win=true;
					gp.pause=true;
					gp.obj[i] = null;
					System.out.println(invC);
				}
				break;
			case "Boots":
				Player.speed=8;
				gp.obj[i] = null;
				break;
			case "Key_Chest":
				gp.key++;
				gp.time=3;
				invC++;
				gp.obj[i] = null;
				break;
			}
			
		}
	}
	
	public void draw(Graphics g2) {
//		g2.setColor(Color.white);
//		g2.fillRect(x,y,gp.tileSize,gp.tileSize);
		
		BufferedImage image= null;
		
		switch(direction) {
		case "up":
			if (footnum==1)
				image=up1;
			if (footnum==2)
				image=up2;
			break;
		case "down":
			if (footnum==1)
				image=down1;
			if (footnum==2)
				image=down2;
			break;
		case "left":
			if (footnum==1)
				image=left1;
			if (footnum==2)
				image=left2;
			break;
		case "right":
			if (footnum==1)
				image=right1;
			if (footnum==2)
				image=right2;
			break;
		}
		g2.drawImage(image,screenX,screenY,gp.tileSize,gp.tileSize,null);
	}
}










