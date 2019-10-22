package client;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import remote.Giaotiep;

public class RMIServer {

	public static void main(String[] args) {
//		Screen sc = new Screen();
//		new Thread(sc).start();
//		
		String host = "192.168.1.100";
		if (args.length > 0) {
			host = args[0];
		}
		try {

			System.setProperty("java.rmi.server.hostname", host);
			Giaotiep call = new Rmi();
			LocateRegistry.createRegistry(8888);
			Registry registry = LocateRegistry.getRegistry(host, 8888);
			UnicastRemoteObject.exportObject(call, 0);
			registry.bind("Hello", call);
			System.out.println("run server");
		} catch (Exception e) {
			e.printStackTrace();

		}
	}
}
