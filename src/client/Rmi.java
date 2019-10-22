package client;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.rmi.RemoteException;

import remote.Giaotiep;

public class Rmi implements Giaotiep {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Robot robo;
	int h, w;
	Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	Rectangle rec;

	public Rmi(Dimension dim) {
		try {
			robo = new Robot();
			h = dim.height;
			w = dim.width;
			rec = new Rectangle(dim);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Rmi() {
		try {
			robo = new Robot();
			h = dim.height;
			w = dim.width;
			rec = new Rectangle(dim);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void keypress(int i) throws RemoteException {
		robo.keyPress(i);
	}

	public void keyReleased(int i) throws RemoteException {
		// TODO Auto-generated method stub
		robo.keyRelease(i);

	}

	public void type(int code) throws RemoteException {
		// TODO Auto-generated method stub
		robo.keyPress(code);
		robo.keyRelease(code);
	}

	public void move(int x, int y) throws RemoteException {
		// TODO Auto-generated method stub
		robo.mouseMove(x, y);
		// BufferedImage screenFullImage = robo.
	}

	public void wheel(int i) throws RemoteException {
		robo.mouseWheel(i);

	}

	public int[] size() throws RemoteException {
		int[] k = new int[2];
		k[0] = w;
		k[1] = h;
		return k;
	}

	public void mouseclick(int a, int count) throws RemoteException {
		if (a == MouseEvent.BUTTON1)
			robo.mousePress(MouseEvent.BUTTON1_DOWN_MASK);
		else if (a == MouseEvent.BUTTON2)
			robo.mousePress(MouseEvent.BUTTON2_DOWN_MASK);
		else if (a == MouseEvent.BUTTON3)
			robo.mousePress(MouseEvent.BUTTON3_DOWN_MASK);
	}

	public void mouseReleased(int a, int count) throws RemoteException {
		if (a == MouseEvent.BUTTON1)
			robo.mouseRelease(MouseEvent.BUTTON1_DOWN_MASK);
		else if (a == MouseEvent.BUTTON2)
			robo.mouseRelease(MouseEvent.BUTTON2_DOWN_MASK);
		else if (a == MouseEvent.BUTTON3)
			robo.mouseRelease(MouseEvent.BUTTON3_DOWN_MASK);
	}
}
