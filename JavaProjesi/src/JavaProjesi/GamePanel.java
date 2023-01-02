package JavaProjesi;

import java.awt.Color;


import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable {
	
	
	static final int genislik=1200;
	static final int uzunluk=600;
	static final Dimension screen = new Dimension(genislik,uzunluk);
	static final int TopGenisligi = 20;
	static final int raket_genisligi = 30;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   ;
	static final int raket_uzunluk = 120;
	Thread gameThread;
	 Image image;
	 Graphics graphics;
	 Random random;
	 Raket raket1;
	 Raket raket2;
	 Top top;
	 Score score;
	 
	GamePanel(){
		Rakett();
		topp();
		score = new Score(genislik,uzunluk);
		this.setFocusable(true);
		this.addKeyListener(new AL()); 
		this.setPreferredSize(screen);
		
		gameThread = new Thread(this);
		gameThread.start();
		
		

	}
	
		
	
	public void topp( ) {
		
		top = new Top((genislik/2)-(TopGenisligi/2),(uzunluk/2)-(TopGenisligi/2),TopGenisligi,TopGenisligi);
	}
	public void Rakett() {
		raket1 = new Raket(0,(uzunluk/2)-(raket_uzunluk/2),raket_genisligi,raket_uzunluk,1);
		raket2 = new Raket(genislik-raket_genisligi,(uzunluk/2)-(raket_uzunluk/2),raket_genisligi,raket_uzunluk,2);

	}
	public void paint(Graphics g) {

image = createImage(getWidth(),getHeight());
graphics = image.getGraphics();
draw(graphics);
g.drawImage(image,0,0, this);


	}
	public void draw(Graphics g) {
		raket1.draw(g);
		raket2.draw(g);
		top.draw(g);
		score.draw(g);
	}
	public void move() {
		top.move();
		
		
	}
	public void carpisma() {
		
		if(top.y <=0) {
			top.YYönü(-top.Yspeed);
		}
		if(top.y >= uzunluk-TopGenisligi) {
			top.YYönü(-top.Yspeed);
		}
		if(top.intersects(raket1)) {
			top.Xspeed = Math.abs(top.Xspeed);
			top.Xspeed++;  
			if(top.Yspeed>0)
				top.Yspeed++;
			else 
				top.Yspeed--;
			top.XYönü(top.Xspeed);
			top.YYönü(top.Yspeed);
		}
		if(top.intersects(raket2)) {
			top.Xspeed = Math.abs(top.Xspeed);
			top.Xspeed++;  
			if(top.Yspeed>0)
				top.Yspeed++;
			else 
				top.Yspeed--;
			top.XYönü(-top.Xspeed);
			top.YYönü(top.Yspeed); 
		}
			
		if(raket1.y<=0) 
			raket1.y=0;
		if(raket1.y >= (uzunluk-raket_uzunluk))
			raket1.y = uzunluk-raket_uzunluk;
		
		if(raket2.y<=0) 
			raket2.y=0;
		if(raket2.y >= (uzunluk-raket_uzunluk))
			raket2.y = uzunluk-raket_uzunluk;
		
		if(top.x <=0) {
			score.oyuncu2++;
			Rakett();
			topp();
			System.out.println("oyuncu 2:"+score.oyuncu2);
			System.out.println("oyuncu iki kazandi");
			System.out.println("oyuncu bir kazandi");
			if(score.oyuncu2==3)
				System.exit(0);	
		
		}
		
		
		
		if(top.x >= genislik-TopGenisligi) {
			
			
				score.oyuncu1++;
				Rakett();
				topp();
				
				System.out.println("oyuncu 1:"+score.oyuncu1);
				System.out.println("oyuncu bir kazandi");
				if(score.oyuncu1==3)
					System.exit(0);	
			
			
			
			
			
			
		}
	}
	
	
	public void run() {
		 

		long lastTime = System.nanoTime();
		double miktar =60.0;
		double saniye = 1000000000/ miktar;
		double delta = 0;
		while(true) {
			long now = System.nanoTime();
			delta += (now -lastTime)/saniye;
			lastTime = now;
			if(delta >=1) {
				move();
				carpisma();
				repaint();
				delta--;
				
			}
		}

		
	}
	public class AL extends KeyAdapter {
		public void keyPressed(KeyEvent e) {
			raket1.keyPressed(e);
			raket2.keyPressed(e);
			
	
			
		}
		public void keyRealeased(KeyEvent e) {
			raket1.keyReleased(e);
			raket2.keyReleased(e);
		
		}
		

	
	}

}
