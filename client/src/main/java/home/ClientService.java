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
        int i;
        int j;
        while (choice!=4) {
            //Runtime.getRuntime().exec("cls");
            System.out.println("MENU:\n1.Calculation of Sum\n2.Finding median\n3.Multiplication of matrix\n4.Exit ");
            Scanner in = new Scanner(System.in);
            choice = in.nextInt();
            switch (choice) {
                case 1:
                    int a;
                    int b;
                    System.out.println("Enter a:\n");
                    a = in.nextInt();
                    System.out.println("Enter b:\n");
                    b = in.nextInt();
                    System.out.println("Sum of "+a+ " and "+ b +" = "+ service.sum(a, b)+"\n");
                    break;
                case 2:
                    int n;
                    System.out.println("Enter length of array:\n");
                    n= in.nextInt();
                    int mas[]=new int[n];
                    System.out.println("Enter elements of array:\n");
                    // заполняем массив
                    for (i=0;i<n;i++){
                        mas[i]=in.nextInt();
                    }
                    System.out.println("Median of the array is: " + service.median(mas)+"\n");
                    break;
                case 3:
                    int M1;
                    int N1;
                    int M2;
                    int N2;

                    System.out.println("Enter data to first matrix:\n");
                    System.out.println("Enter the number of rows:\n");
                    M1=in.nextInt();
                    System.out.println("Enter the number of columns:\n");
                    N1=in.nextInt();
                    double [][] matrA=new double[M1][N1];
                    //заполнение первой матрицы
                    for (i=0;i<M1;i++){
                        for(j=0;j<N1;j++){
                            matrA[i][j]=in.nextInt();
                        }
                    }

                    System.out.println("Enter data to second matrix:\n");
                    System.out.println("Enter the number of rows:\n");
                    M2=in.nextInt();
                    System.out.println("Enter the number of columns:\n");
                    N2=in.nextInt();
                    double [][] matrB=new double[M2][N2];
                    //заполнение второй матрицы
                    for (i=0;i<M2;i++){
                        for(j=0;j<N2;j++){
                            matrB[i][j]=in.nextInt();
                        }
                    }



                    //!!! жалуется на эту строчку
                    //System.out.println("Multiplication of two arrays: " + Arrays.deepToString(matrA) + " and " + Arrays.deepToString(matrB)
                      //      + " is: " + Arrays.deepToString(service.multiply(matrA, matrB))+"\n");
                    //Double[][] A = {{4.00, 3.00}, {2.00, 1.00}};
                    //Double[][] B = {{-0.500, 1.500}, {1.000, -2.0000}};
                    break;

            }
        }

    }
}
