package Main;

import java.awt.event.*;
public class KeyHand implements KeyListener {
	public boolean upp,downp,leftp,rightp,shiftp;
	

	@Override
	public void keyPressed(KeyEvent e) {
		int code=e.getKeyCode(); 
		if(code==KeyEvent.VK_W || code==KeyEvent.VK_UP) {
			upp=true;
		}
		if(code==KeyEvent.VK_S ||code==KeyEvent.VK_DOWN) {
			downp=true;
		}
		if(code==KeyEvent.VK_A ||code==KeyEvent.VK_LEFT) {
			leftp=true;
		}
		if(code==KeyEvent.VK_D||code==KeyEvent.VK_RIGHT) {
			rightp=true;
			
		}	
		if (code==KeyEvent.VK_SHIFT) {
			shiftp=true;
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		int code=e.getKeyCode();
				if(code==KeyEvent.VK_W || code==KeyEvent.VK_UP) {
					
					upp=false;
				}
				if(code==KeyEvent.VK_S ||code==KeyEvent.VK_DOWN) {
					downp=false;
				}
				if(code==KeyEvent.VK_A ||code==KeyEvent.VK_LEFT) {
					leftp=false;
				}
				if(code==KeyEvent.VK_D||code==KeyEvent.VK_RIGHT) {
					rightp=false;
				}		
				if (code==KeyEvent.VK_SHIFT) {
					shiftp=false;
				}
				if (code==KeyEvent.VK_ESCAPE) {
					if (GamePanel.pause) GamePanel.pause=false; else GamePanel.pause=true;
				}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	

}
