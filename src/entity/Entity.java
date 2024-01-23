package entity;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Entity {
	public int worldx,worldy;
	public static int speed;
	public String direction;
	public BufferedImage ahead,up,up1,up2,down,down1,down2,left,left1,left2,right,right1,right2;
	
	public int footcount=0;
	public int footnum=1;
	public Rectangle solidArea;
	public int solidAreaDefaultX,solidAreaDefaultY;
	public boolean collisionON=false;
}
