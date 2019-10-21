package teamview;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import remote.Giaotiep;

public class GetRmi {

	public static Giaotiep get(String s) {
		try {
			Registry registry;
			registry = LocateRegistry.getRegistry(s, 8888);
			Giaotiep c = (Giaotiep) registry.lookup("Hello");
			System.out.println("tao thanh cong");
			return c;
		} catch (Exception e) {
			e.printStackTrace();
			return null ;
		}
	}

}
