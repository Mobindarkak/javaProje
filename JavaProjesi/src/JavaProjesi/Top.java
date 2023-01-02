package JavaProjesi;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Top extends Rectangle {
	
	
	Random random;
	int Xspeed;
	int Yspeed;
	
	
		Top(int x,int y,int z,int k){

		super(x,y,z,k);
		random = new Random();
		int randomXYonu = random.nextInt(2);
		if(randomXYonu == 0)
			randomXYonu --;
		 XYönü(randomXYonu);
		 
		 int randomYYonu = random.nextInt(2);
			if(randomYYonu == 0)
				randomYYonu --;
			 YYönü(randomYYonu);
	}
		
	public void XYönü(int randomXYönü) {
		Xspeed = randomXYönü;
		
	}
	public void YYönü(int randomYYönü) {
		Yspeed = randomYYönü;
		
	}
	public void move() {
		x += Xspeed;
		y += Yspeed;
		
	}
	public void draw(Graphics g) {

		g.setColor(Color.yellow);
		g.fillOval(x,y,height,width);
	
		
	}
	
}
