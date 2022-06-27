package GUI2.copy;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener{
Gameplay gameplay;





	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_A)
		{
			System.out.println("Ana Shagal");
			
		}
//		if(e.getKeyCode() == KeyEvent.VK_S)
//			//gameplay.movedown.doClick();
//		if(e.getKeyCode() == KeyEvent.VK_D)
//			//gameplay.moveright.doClick();
//		if(e.getKeyCode() == KeyEvent.VK_W)
//			//gameplay.moveup.doClick();
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
