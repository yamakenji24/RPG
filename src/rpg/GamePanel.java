package rpg;

import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.applet.*;
import java.net.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.event.*;
import javax.swing.border.*;

public class GamePanel extends JPanel implements Runnable, KeyListener{
	MainPanel mp;
	private int x, y, movement=20;
	 BufferedImage ground1,ground2;
	 //BufferedImage img[] = new BufferedImage[13];
	 BufferedImage img;
	 boolean in_game = true;
	 String message = "1‰ñ–Ú";
	 private Thread thread;
	 int i,j;
	 
	public GamePanel(MainPanel tmp) {
		setLayout(null);
		try {
			ground1 = ImageIO.read(new File("images/grass.jpg"));
			/*for ( int k = 1; k <= 12; k++) {
				//img[k] = ImageIO.read(new File("images/man"+k+".jpg"));
				img[2] = ImageIO.read(new File("images/man2.png"));
			}*/
			img = ImageIO.read(new File("./images/man2.png"));
		} catch(IOException e) {
			e.printStackTrace();
		}
		x = 0; y = 0;
		addKeyListener(this);
		thread = new Thread(this);
		thread.start();
	}
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.clearRect(0, 0, 800, 700); 
		for ( i = 0; i < 800; i += movement) {
			for ( j = 0; j < 700; j += movement) {
				g.drawImage(ground1,  i,  j,  20,  20,  null);
			}
		}
		g.drawString(message,  100,  100);
		g.drawImage(img, x, y, 40, 40, null);
	}
	
	public void run() {
		requestFocus();
		while (in_game) {
			repaint();
			try {
				Thread.sleep(200);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		switch (key) {
			case 'W':  y -= 20; break;
			case 'S':  y += 20; break;
			case 'A':  x -= 20; break;
			case 'D':  x += 20; break;
		}
		repaint();
	}

	@Override
	public void keyReleased(KeyEvent arg0) {	
	}
	
	@Override
	public void keyTyped(KeyEvent arg0) {
	}
}
