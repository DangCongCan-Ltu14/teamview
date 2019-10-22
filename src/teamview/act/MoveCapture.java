package teamview.act;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

import remote.Giaotiep;

public class MoveCapture implements MouseMotionListener {
	int h, w;
	Giaotiep gt;
	JPanel jp;

	public MoveCapture(JPanel p, Giaotiep s) {
		gt = s;
		jp = p;
		try {
			int a[] = gt.size();
			w = a[0];
			h = a[1];
		} catch (Exception e) {
			System.out.println("loi khoi tao movecaptre");
			e.printStackTrace();
		}
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		int x = e.getX(), y = e.getY();
		int p = x * w / jp.getWidth(), q = y * h / jp.getHeight();
		try {
			gt.move(p, q);
			Thread.sleep(15);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		int x = e.getX(), y = e.getY();
		int p = x * w / jp.getWidth(), q = y * h / jp.getHeight();
		try {
			gt.move(p, q);
			Thread.sleep(15);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

}
