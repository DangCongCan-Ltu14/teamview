package teamview;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTextField;

import client.Rmi;
import remote.Giaotiep;
import teamview.act.KeyCapture;
import teamview.act.MouseCapture;
import teamview.act.MoveCapture;
import teamview.act.WheelCapture;

/**
 * author: amneiht - dang cong can
 */
public class App extends JFrame {
	public static String status="chua co gi";
	public static void main(String[] args) {
		new App("127.0.0.1");
	}

	public Giaotiep trmi;

	public App(String s) {
		trmi = GetRmi.get(s);
		if (trmi != null) {
			status="ok";
			init();
			GetScreen.run=true;
			GetScreen sc = new GetScreen(this.panel, this.image, s);
			new Thread(sc).start();
		}else
		{
			status="err";
		}
	}

	public App() {
		//
		trmi = new Rmi();
		init();
		new GetScreen(this.panel, this.image, "localhost");
	}

	private void init() {

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		this.setVisible(true);
		JMenu mnMenu = new JMenu("menu");
		menuBar.add(mnMenu);
		this.setSize(1000, 700);

		JTextField textField = new JTextField();
		textField.setColumns(10);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		addKeyListener(new KeyCapture(trmi));
		addMouseWheelListener(new WheelCapture(trmi));
		panel = new JPanel();
		panel.setFocusable(true);

		panel.addMouseListener(new MouseCapture(trmi));
		panel.addMouseMotionListener(new MoveCapture(panel, trmi));

		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.TRAILING).addGroup(groupLayout
				.createSequentialGroup().addContainerGap()
				.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 970, Short.MAX_VALUE)
						.addComponent(textField, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 970, Short.MAX_VALUE))
				.addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.TRAILING).addGroup(groupLayout
				.createSequentialGroup().addContainerGap()
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 591, Short.MAX_VALUE).addGap(18).addComponent(textField,
						GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
				.addContainerGap()));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGap(0, 875, Short.MAX_VALUE));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGap(0, 575, Short.MAX_VALUE));
		panel.setLayout(gl_panel);

		getContentPane().setLayout(groupLayout);
	}

	public void paint(Graphics g) {
		super.paint(g);

		pdesktop();
	}

	private void pdesktop() {
		// TODO Auto-generated method stub
		if (panel != null && image != null) {
			Graphics graphics = panel.getGraphics();
			graphics.drawImage(image, 0, 0, panel.getWidth(), panel.getHeight(), null);
			graphics.dispose();
		}
	}
//public exit()
	protected void paindraw() {
		try {
			System.out.println(panel.getWidth() + "  " + panel.getHeight());
			image = ImageIO.read(new File("/home/dccan/Pictures/sc.png"));
			image = image.getScaledInstance(panel.getWidth(), panel.getHeight(), Image.SCALE_FAST);
			Graphics graphics = panel.getGraphics();
			graphics.drawImage(image, 0, 0, panel.getWidth(), panel.getHeight(), panel);
			graphics.dispose();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	Image image = null;
	private static final long serialVersionUID = 1L;
	private JPanel panel;
}
