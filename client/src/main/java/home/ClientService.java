package home;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Arrays;
import java.util.Scanner;

public class ClientService {

    public static void main(String... args) throws Exception {
        Registry registry = LocateRegistry.getRegistry("localhost", 2099);
        RemoteService service = (RemoteService) registry.lookup("sample/RemoteService");


        int choice=0;
        while (choice!=4) {
            System.out.println("MENU:\n1.Calculation of Sum\n2.Finding median\n3.Multiplication of matrix\n4.Exit ");
            Scanner in = new Scanner(System.in);
            choice = in.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Sum of 4 and 5 = " + service.sum(4, 5)+"\n");
                    break;
                case 2:
                    System.out.println("Median of the array [1, 2, 3] is: " + service.median(new int[]{1, 2, 3})+"\n");
                    break;
                case 3:
                    Double[][] A = {{4.00, 3.00}, {2.00, 1.00}};
                    Double[][] B = {{-0.500, 1.500}, {1.000, -2.0000}};
                    System.out.println("Multiplication of two arrays: " + Arrays.deepToString(A) + " and " + Arrays.deepToString(B)
                            + " is: " + Arrays.deepToString(service.multiply(A, B))+"\n");
                    break;

            }
        }

    }
}
