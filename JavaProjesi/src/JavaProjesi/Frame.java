package JavaProjesi;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Frame extends JFrame {
	Frame(){
		
		
	GamePanel panel;
	panel = new GamePanel();
	this.add(panel);
	this.setTitle("masa ustu tenis");
	this.setResizable(false);
	this.setBackground(Color.black);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.pack();
	this.setVisible(true);
	this.setLocationRelativeTo(null);
	
	}
}
	