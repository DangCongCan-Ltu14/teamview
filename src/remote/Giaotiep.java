package remote;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Giaotiep extends Remote {
	public void keypress(int i) throws RemoteException;

	public void keyReleased(int i) throws RemoteException;

	public void type(int i) throws RemoteException;

	public void move(int x, int y) throws RemoteException;

	public void wheel(int i) throws RemoteException;

	public int[] size() throws RemoteException;
	
	public void mouseclick(int a, int count)  throws RemoteException;
	
	public void mouseReleased(int a, int count)  throws RemoteException;
}
