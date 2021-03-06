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

public class StartMenu extends JPanel implements ActionListener{
	MainPanel mp;
	BufferedImage background;
	JButton startButton, instructions;
	
	public StartMenu(MainPanel tmp) {
		super();
		mp = tmp;
		try {
			background = ImageIO.read(new File("images/title.jpg"));
		} catch(IOException e) {
			e.printStackTrace();
		}
		setLayout(null);
		setOpaque(true);
		startButton = new JButton("GAME START!");
		instructions = new JButton("操作説明");
		startButton.setLocation(320, 400);
		instructions.setLocation(320, 500);
		startButton.setSize(150,50);
		instructions.setSize(150,50);
		startButton.addActionListener(this);
		instructions.addActionListener(this);
		add(startButton);
		add(instructions);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.clearRect(0, 0, 800, 700); 
		g.drawImage(background,  0,  0,  800,  700,  null);
		g.setFont(new Font(Font.SERIF, Font.BOLD, 50));
		g.setColor(Color.red);
		g.drawString("お試し作成中",  250,  200);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == instructions) {
			mp.state=1;
		} else if (e.getSource() == startButton) {
			mp.state=2;
		}
	}
	
}
