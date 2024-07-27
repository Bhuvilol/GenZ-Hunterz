package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener{
	public boolean upPressed , downPressed, leftPressed, rightPressed;
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		// TODO Auto-generated method stub
		int code = e.getKeyCode();
		
		if (code == KeyEvent.VK_W) {
			upPressed = true;
		}
		if (code == KeyEvent.VK_W) {
			downPressed = true;
		}
		if (code == KeyEvent.VK_W) {
			leftPressed = true;
		}
		if (code == KeyEvent.VK_W) {	
			rightPressed = true;
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
int code = e.getKeyCode();
		
		if (code == KeyEvent.VK_W) {
			upPressed = false;
		}
		if (code == KeyEvent.VK_W) {
			downPressed = false;
		}
		if (code == KeyEvent.VK_W) {
			leftPressed = false;
		}
		if (code == KeyEvent.VK_W) {	
			rightPressed = false;
		}
	}

}
