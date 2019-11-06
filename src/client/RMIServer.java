package client;

import java.net.DatagramSocket;
import java.net.InetAddress;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import remote.Giaotiep;

public class RMIServer {
	static Screen sc;
	static Registry registry;
	static String host;

	public static String getHost() {
		return host;
	}

	public static void main(String[] args) throws InterruptedException {
		init();
		System.out.println(host);
		Run();
//		Thread.sleep(10000);
//		stop();
	}

	public static void init() {
		try {
			DatagramSocket socket = new DatagramSocket();
			socket.connect(InetAddress.getByName("8.8.8.8"), 10002);
			host = socket.getLocalAddress().getHostAddress();
			socket.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static void Run() {
		System.gc();

		sc = new Screen();
		Screen.run = true;
		new Thread(sc).start();
		try {
			System.setProperty("java.rmi.server.hostname", host);
			registry = LocateRegistry.createRegistry(8888);
			Rmi.run = true;
			Giaotiep call = new Rmi();
			UnicastRemoteObject.exportObject(call, 0);
			registry.rebind("Hello", call);
			System.out.println("run server");
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public static void stop() {
		Screen.run = false;
		try {
			registry.unbind("Hello");
			Rmi.run = false;
			UnicastRemoteObject.unexportObject(registry, true);
			System.out.println("stop");

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
