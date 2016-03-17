package calculation;

import java.rmi.RemoteException;

import client.Callback;

public interface Calculation {

	public void calculate(int digits);
	public void getResult(Callback clientstub) throws RemoteException;
}
