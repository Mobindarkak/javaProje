package JavaProjesi;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;

public class Score extends Rectangle{
	static int genislik;
	static int uzunluk;
	int oyuncu1;
	int oyuncu2;

	
	Score(int genislik,int uzunluk){
		Score.genislik = uzunluk;
		Score.uzunluk =genislik;
		
	}
	public void draw(Graphics g) {
		g.setColor(Color.white);
		g.drawLine(600,600,600,0);
		 Graphics2D g2 = (Graphics2D)g;
	        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	        
		
			g2.setStroke(new BasicStroke(3));
	        g.setColor(Color.white);
	        g.drawArc(1120, 0, 70, 600, 90, 180);
	        g.setColor(Color.white);
	        g.drawArc(0, 0, 70, 600, 90, -180);
	        
	        g2.setColor(Color.white);
	        g2.fillOval(585, 287, 30, 30);
	        
		
		g.drawString(String.valueOf(oyuncu1),(genislik/2)+155,50);
		g.drawString(String.valueOf(oyuncu2),(genislik/2)+420,50);
		
		

	}

}
