package teamview.act;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyCapture implements KeyListener{

	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println("s");
	}

	@Override
	public void keyReleased(KeyEvent e) {
		System.out.println("sss");
	}

	@Override
	public void keyTyped(KeyEvent e) {
		System.out.println("ssas");
	}

}
