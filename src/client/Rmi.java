package client;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.InputEvent;
import java.rmi.RemoteException;

import remote.Giaotiep;

public class Rmi implements Giaotiep {
	Robot robo;
	int h, w;
	Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	Rectangle rec ;
	public Rmi(Dimension dim) {
		try {
			robo = new Robot();
			h = dim.height;
			w = dim.width;
			rec =new Rectangle(dim);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Rmi() {
		try {
			robo = new Robot();
			h = dim.height;
			w = dim.width;
			rec =new Rectangle(dim);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void keypress(int i) throws RemoteException {
		robo.keyPress(i);
	}

	@Override
	public void keyReleased(int i) throws RemoteException {
		// TODO Auto-generated method stub
		robo.keyRelease(i);

	}

	@Override
	public void type(int code) throws RemoteException {
		// TODO Auto-generated method stub
		robo.keyPress(code);
		robo.keyRelease(code);
	}

	@Override
	public void move(int x, int y) throws RemoteException {
		// TODO Auto-generated method stub
		robo.mouseMove(x, y);
		// BufferedImage screenFullImage = robo.
	}

	@Override
	public void wheel(int i) throws RemoteException {
		robo.mouseWheel(i);

	}

	@Override
	public int[] size() throws RemoteException {
		int [] k=new int [2];
		k[0]=w;k[1]=h;
		return k ;
	}

	public void mouseclick(int a, int count) throws RemoteException {
		if (a == InputEvent.BUTTON1_MASK)
			robo.mousePress(a);
		else if (a == InputEvent.BUTTON2_MASK)
			robo.mousePress(a);
		else if (a == InputEvent.BUTTON3_MASK)
			robo.mousePress(a);
	}

	public void mouseReleased(int a, int count) throws RemoteException {
		if (a == InputEvent.BUTTON1_MASK)
			robo.mouseRelease(a);
		else if (a == InputEvent.BUTTON2_MASK)
			robo.mouseRelease(a);
		else if (a == InputEvent.BUTTON3_MASK)
			robo.mouseRelease(a);
	}
}
