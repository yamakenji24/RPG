package rpg;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;

public class Instruction extends JPanel implements ActionListener {
	MainPanel mp;
	BufferedImage instback;
	JButton goback;
	public Instruction(MainPanel tmp) {
		super();
		mp = tmp;
		try {
			instback = ImageIO.read(new File("images/instruction.jpg"));
		} catch(IOException e) {
			e.printStackTrace();
		}
		setLayout(null);
		setOpaque(true);
		goback = new JButton("ñﬂÇÈ");
		goback.setLocation(320, 600);
		goback.setSize(150,50);
		goback.addActionListener(this);
		this.add(goback);
	}
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.clearRect(0, 0, 800, 700); 
		g.drawImage(instback,  0,  0,  800,  700,  null);
		g.setFont(new Font(Font.SERIF, Font.BOLD, 50));
		g.setColor(Color.red);
		g.drawString("ëÄçÏê‡ñæçÏê¨íÜ",  250,  200);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == goback) {
			goback.setEnabled(false);
			remove(goback);
			mp.state=0;
		}
		
	}

}
