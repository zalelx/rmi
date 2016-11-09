package home;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteService extends Remote {
    String BINDING_NAME = "sample/RemoteService";
    String HOST = "localhost";
    int PORT = 2099;

    int sum(int a, int b) throws RemoteException;

    double median(int[] array) throws RemoteException;

    Double[][] multiply(Double[][] A, Double[][] B) throws RemoteException;

}
