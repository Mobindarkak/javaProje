package JavaProjesi;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class Raket extends Rectangle{
	int kisi;
	int Yspeed;
	
	
 Raket(int x, int y, int raket_uzunluk, int raket_genisligi, int kisi){
	 super(x,y,raket_genisligi,raket_uzunluk);
	 this.kisi=kisi;
	 
	 
 }
 public void keyPressed(KeyEvent e) {
	 switch(kisi) {
	 case 1:
		 if(e.getKeyCode()==KeyEvent.VK_W) {
			 YYönü(-10);
			 move();
		 }
		 if(e.getKeyCode()==KeyEvent.VK_S) {
			 YYönü(+10);
			 move();
		 }
		 break;
	 case 2:
		 if(e.getKeyCode()==KeyEvent.VK_UP) {
			 YYönü(-10);
			 move();
		 }
		 if(e.getKeyCode()==KeyEvent.VK_DOWN) {
			 YYönü(+10);
			 move();
		 }
		 break;
	 }
		
	}
 public void keyReleased(KeyEvent e) {
	 switch(kisi) {
	 case 1:
		 if(e.getKeyCode()==KeyEvent.VK_W) {
			 YYönü(0);
			 move();
		 }
		 if(e.getKeyCode()==KeyEvent.VK_S) {
			 YYönü(0);
			 move();
		 }
		 break;
	 case 2:
		 if(e.getKeyCode()==KeyEvent.VK_UP) {
			 YYönü(0);
			 move();
		 }
		 if(e.getKeyCode()==KeyEvent.VK_DOWN) {
			 YYönü(0);
			 move();
		 }
		 break;
	 }
		
	}
	public void YYönü(int yYönü){
		Yspeed = yYönü;
		
	} 
	public void move() {
		y=y + Yspeed;
		
	}
	public void draw(Graphics g) {
		if(kisi==1)
			g.setColor(Color.magenta);
		else 
			g.setColor(Color.green);
		g.fillRect(x, y,height, width);
		

	}
		
}
