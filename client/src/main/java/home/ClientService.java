package home;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Arrays;

public class ClientService {

    public static void main(String... args) throws Exception {
        Registry registry = LocateRegistry.getRegistry("localhost", 2099);
        RemoteService service = (RemoteService) registry.lookup("sample/RemoteService");
        System.out.println("Sum of 4 and 5 = " + service.sum(4, 5));
        System.out.println("Median of the array [1, 2, 3] is: " + service.median(new int[]{1, 2, 3}));
        Double[][] A = {{4.00, 3.00}, {2.00, 1.00}};
        Double[][] B = {{-0.500, 1.500}, {1.000, -2.0000}};
        System.out.println("Multiplication of two arrays: " + Arrays.deepToString(A) + " and " + Arrays.deepToString(B)
                + " is: " + Arrays.deepToString(service.multiply(A, B)));
    }
}
