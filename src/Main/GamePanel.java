package Main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Currency;

import javax.swing.JPanel;

import Tile.TileManager;
import entity.Player;
import object.SuperObject;

public class GamePanel extends JPanel implements Runnable {
	
	
	public static boolean pause=false, win=false;
	
	final int originalTileSize=16;
	final int scale =3;
	
	public final int tileSize=originalTileSize * scale;
	public final int maxScreenCol=17;
	public final int maxScreenRow=12;
	public final int screenWidth=tileSize*maxScreenCol;
	public final int screenHeight=tileSize*maxScreenRow;
	
	KeyHand keyH= new KeyHand();
	Thread gameThread;
	public CollisionChecker cChecker= new CollisionChecker(this);
	public AssetSetter aSetter = new AssetSetter(this);
	public Player player = new Player(this,keyH);
	public SuperObject obj[] = new SuperObject[20];
	
	
	//player position
	
	int pX=100;
	int pY=100;
	int speed=4;
	
	TileManager tileM=new TileManager(this);
	
	//WORLD SETTINGS
		public final int maxworldcol=50;
		public final int maxworldrow=50;
		public final int worldwidth=tileSize*maxworldcol;
		public final int worldheight=tileSize*maxworldrow;
		
		
		
		
	public GamePanel() {
		this.setPreferredSize(new Dimension(screenWidth,screenHeight));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
		this.addKeyListener(keyH);
		this.setFocusable(true);
		
	}
	
	public void setup() {
		
		aSetter.setObject();
	}
	int drawCount;
	
	
	public void startgame() {
		
		gameThread = new Thread(this);
		gameThread.start();
		
	}
	boolean run=false;
	int fps=60;
	public static int time =0;
	@Override
	
	public void run() {
		
		while(gameThread!=null) {
//			System.out.println(System.nanoTime());
			double draw=1000000000/fps;
			double del=0;
			long lasttime=System.nanoTime();
			long currenttime;
			long timer=0;
			drawCount=0;
			repaint();
			while (gameThread != null && pause ==false ) {
				currenttime=System.nanoTime();
				del+= (currenttime-lasttime)/draw;
				timer+= (currenttime- lasttime);
//				System.out.println(del+" "+currenttime+" "+lasttime+" "+draw);
				lasttime=currenttime; // xử lí khung hình kiểu delta
				
				if (del>= 1) {
//					System.out.println("The game loop is running");
					// 1 update: update infor về nhân vật, vị trí các kiểu
//					System.out.println(pX+"--"+pY);
					update();
					
					// 2 draw: vẽ lại khung hình
					
					repaint();
					del--;
					drawCount++;
				}
				if (timer>=1000000000) {
					System.out.println("FPS: "+drawCount);
					
					if (player.speed > 4)  { 
						player.speed--;
						run=true;
						
					} else run=false;
					if (time>0) time--;
					
					drawCount=0;
					timer=0;
				}
				

			}
		}
	}
	public void update() {
		player.update();
	}
	public static int key=0;
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		Graphics2D g2= (Graphics2D)g;
		
		//tile
		tileM.draw(g2);
		//object
		for (int i=0; i< obj.length;  i++) {
			if (obj[i] != null) {
				obj[i].draw(g2,this);
			}
		}
		//player
		player.draw(g2);
		Font pixelFont = new Font("PixelFont", Font.PLAIN, 30);
		Font pixelFont2 = new Font("PixelFont", Font.PLAIN, 20);
		Font pixelFont3 = new Font("PixelFont", Font.PLAIN, 30);
        g2.setFont(pixelFont);
        // Vẽ chữ lên BufferedImage
        g2.setColor(Color.WHITE);
        g2.drawString("Key Door: " + player.invK, 10, 30);
        g2.drawString("Key Chest: " + player.invC, 10, 60); 
        g2.setFont(pixelFont2);
        g2.drawString("HOW TO MOVE", 10, 90);
        g2.drawString("UP: W or Up Key", 10, 110);
        g2.drawString("DOWN: S or Down Key", 10, 130);
        g2.drawString("RIGHT: D or Right Key", 10, 150);
        g2.drawString("LEFT: A or Left Key", 10, 170);
        g2.drawString("Total Key to win: 5 ", 10, 190);
        g2.drawString("Your Total key: "+key, 10, 210);
        g2.setFont(pixelFont3);
        g2.setColor(Color.RED);
        g2.drawString("OPEN ALL CHEST TO WIN!!", 350, 30);
        if (run)  g2.drawString("RUNNNN!!", 450, 60);
        if (win) {
        	g2.setColor(Color.YELLOW);
        	g2.drawString("CONGRATULATION!!", 450, 360);
        	g2.drawString("YOU ARE WINNER!!", 450, 390);
        } else
        if (pause) g2.drawString("PAUSE!!", 450, 360);
        g2.setColor(Color.YELLOW);
        if (time>0) g2.drawString("YOU GOT A KEY!!", 450, 360);
        
        
        
		g2.dispose();
	}
	
}
