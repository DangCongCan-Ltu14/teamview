package events;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
// 337 600
public class screen {
	public static void main(String[] args) throws AWTException {
		Robot bobo = new Robot();
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		Rectangle rec = new Rectangle(dim);
		System.out.println(dim.height+" "+dim.width);
		show.pr(bobo.createScreenCapture(rec));
		

	}
}
