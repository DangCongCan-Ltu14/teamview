package teamview.act;

import java.awt.event.KeyEvent;

public class KeyMap {
	static int[] map = { KeyEvent.VK_CONTROL, KeyEvent.VK_ALT, KeyEvent.VK_SHIFT }; // phim dieu kien

	public static boolean isControl(int a) {
		int x = map.length;
		for (int i = 0; i < x; i++) {
			if (a == map[i])
				return true;
		}
		return false;
	}
}
