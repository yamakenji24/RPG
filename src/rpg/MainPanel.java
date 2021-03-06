package rpg;
import java.awt.*; 
import java.awt.event.*;
import javax.swing.*;
import java.applet.*;
import java.net.*;

public class MainPanel extends JLayeredPane implements Runnable{
	StartMenu sm;
	Instruction ins;
	GamePanel gm;

	boolean in_game = true; //ゲーム状態(0:表紙  1:操作説明 2:ゲーム画面
	public int state = 0;
	int old_state = 0;
	Thread td;

	public MainPanel(int width) {
		sm = new StartMenu(this);
		sm.setBounds(0, 0, 800, 700);
		add(sm);
		td = new Thread(this);
		td.start();
	}


	@Override
	public void run() {
		while (in_game) {
			try {
				td.sleep(100);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}

			if (state != old_state) {
				if ( old_state == 0) {
					remove(sm);
				} else if(old_state == 1) {
					remove(ins);
				} else if(old_state == 2) {
					remove(gm);
				}

				if ( state == 4) {
					in_game =false;
				} else {
					if ( state == 0) {
						sm = new StartMenu(this);
						sm.setBounds(0, 0, 800, 700);
						add(sm);
					} else if ( state == 1) {
						ins = new Instruction(this);
						ins.setBounds(0, 0, 800, 700);
						add(ins);
					} else if(state == 2) {
						gm = new GamePanel(this);
						gm.setBounds(0, 0, 800, 700);
						add(gm);
					}
					validate();
					old_state=state;
				}
			}
		}
	}
}
