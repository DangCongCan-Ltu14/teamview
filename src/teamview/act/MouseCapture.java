package teamview.act;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import remote.Giaotiep;

public class MouseCapture implements MouseListener {
	Giaotiep gt ;
	public MouseCapture(Giaotiep s)
	{
		gt=s; 
	}
	public void mouseClicked(MouseEvent e) {
	try {
		gt.mouseReleased(e.getButton(), e.getClickCount());
	} catch (Exception e2) {
		e2.printStackTrace();	
	}
	
		
	}
	public void mouseReleased(MouseEvent e) {
		try {
			gt.mouseReleased(e.getButton(), e.getClickCount());
		} catch (Exception e2) {
			e2.printStackTrace();	
		}
		
	}
	public void mousePressed(MouseEvent e) {
		try {
			gt.mouseclick(e.getButton(), e.getClickCount());
		} catch (Exception e2) {
			e2.printStackTrace();	
		}
	}
	public void mouseEntered(MouseEvent e) {
		
		//no thinh to do
		
	}
	public void mouseExited(MouseEvent e) {
		// do no thing
		
	}

	
	

	

}
