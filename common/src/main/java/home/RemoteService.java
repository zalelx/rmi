package home;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteService extends Remote {

    int sum(int a, int b) throws RemoteException;

    double median(int[] array) throws RemoteException;

    Double[][] multiply(Double[][] A, Double[][] B) throws RemoteException;

}
