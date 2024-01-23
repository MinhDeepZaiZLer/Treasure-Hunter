package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class KeyChest extends SuperObject {
	
	public KeyChest() {
		
		name="Key_Chest";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/KeyC.png"));
		} catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
