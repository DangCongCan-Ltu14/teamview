package teamview.act;

import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import remote.Giaotiep;

public class WheelCapture implements MouseWheelListener {
	Giaotiep gt;

	public WheelCapture(Giaotiep s) {
		gt = s;
	}

	public void mouseWheelMoved(MouseWheelEvent e) {
		// TODO Auto-generated method stub
		int not = e.getWheelRotation();
		try {
			gt.wheel(not);
		} catch (Exception e2) {
			// TODO: handle exception
			e2.printStackTrace();
		}
	}

}
