package client;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.ImageIcon;

public class Screen implements Runnable {
	int port = 6677;
	String host = "localhost";
	boolean run = true;
	Robot rb;
	int frame = 15;

	public static void main(String[] args) {
		Screen sc = new Screen();
		new Thread(sc).start();
	}

	public Screen() {
		try {
			rb = new Robot();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void run() {
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		Rectangle rec = new Rectangle(dim);
		int sleep = 1000 / 15;

		while (run) {
			try {
				Socket s = new Socket(host, port);
				ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());

				BufferedImage image = rb.createScreenCapture(rec);
				ImageIcon imageIcon = new ImageIcon(image);
				try {
					out.writeObject(imageIcon);
					out.reset(); // Clear ObjectOutputStream cache
					System.out.println("New screenshot sent");
					try {
						Thread.sleep(sleep);
					} catch (Exception e) {
						// TODO: handle exception
					}

				} catch (IOException ex) {
					ex.printStackTrace();
				}
				out.close();
				s.close();

			} catch (Exception e) {

			}
		}

	}

}
