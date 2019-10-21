package events;
/*
 * BlankArea.java is used by:
 *    MouseEventDemo.java.
 *    MouseMotionEventDemo.java
 */

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

public class BlankArea extends JLabel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2006326518500782623L;
	Dimension minSize = new Dimension(100, 50);

	public BlankArea(Color color) {
		setBackground(color);
		setOpaque(true);
		setBorder(BorderFactory.createLineBorder(Color.black));
	}

	public Dimension getMinimumSize() {
		return minSize;
	}

	public Dimension getPreferredSize() {
		return minSize;
	}
}