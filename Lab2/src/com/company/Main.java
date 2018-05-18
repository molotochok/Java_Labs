package com.company;
import java.util.Scanner;

public class Main {

    public static double[][] inizialize(int m, int n, String matrixName){
        Scanner in = new Scanner(System.in);

        double[][] a = new double[m][n];
        System.out.println("\nMatrix " + matrixName + ":");
        for(int i =0;i < m;i++){
            for(int j = 0;j < n;j++){
                System.out.print(matrixName + "[" + (i+1) + "][" + (j+1) + "]= ");

                if(!in.hasNextDouble()){
                    System.out.println("Double number shouldn't contain dot. Use coma");
                    return null;
                }
                a[i][j] = in.nextDouble();
            }
        }
        return a;
    }

    public static double[][] multiply(double[][] a, double[][] b){
        int rowA = a.length;
        int rowB = b.length;
        int colB = b[0].length;

        double[][] result = new double[rowA][colB];
        double sum = 0;
        for(int i = 0;i < rowA;i++){
            for(int j = 0;j < colB;j++){
                sum=0;
                for(int k = 0;k < rowB;k++){
                    sum += a[i][k] * b[k][j];
                }
                result[i][j] = sum;
            }
        }

        return result;
    }
    public static void outputMatrix(double[][] a, String matrixName){
        int row = a.length;
        int col = a[0].length;
        String out = new String("");
        out += "\nMatrix " + matrixName + ":\n";

        for(int i = 0;i < row;i++){
            for(int j = 0;j < col;j++){
                out += a[i][j] + "\t";
            }
            out += "\n";
        }
        System.out.print(out);
    }

    public static int getNumber(String name){
        Scanner in = new Scanner(System.in);

        int number = 0;

        System.out.print(name + " = ");
        if(!in.hasNextInt()){
            System.out.println("m1 should be a number of type int");
            return 0;
        }
        number = in.nextInt();
        number = Math.max(0,number);
        if(number == 0){
            System.out.println(name + " can't be less or equal 0");
        }
        return number;
    }

    public static double getSumOfMinElemInCol(double[][] a){
        int row = a.length;
        int col = a[0].length;

        double min;
        double sum = 0;
        for(int i = 0;i < col;i++){
            min = a[0][i];
            for(int j = 0;j < row;j++){
                if(a[j][i] < min){
                    min = a[j][i];
                }
            }
            sum += min;
        }

        return sum;
    }

    public static void main(String[] args) {
        // First matrix
        System.out.println("Matrix A:");
        int rowA = getNumber("rows"); //rows
        if(rowA == 0){
            return;
        }
        int colA = getNumber("columns"); //columns
        if(colA == 0){
            return;
        }

        // Second matrix
        System.out.println("\nMatrix B:");
        int rowB = colA;
        System.out.println("rows = " + rowB);

        int colB = getNumber("columns"); //columns
        if(colB == 0){
            return;
        }

	    double[][] a = inizialize(rowA,colA,"A");
	    if(a == null){
	        System.out.println("Something went wrong");
	        return;
        }
	    double[][] b = inizialize(rowB,colB,"B");
        if(b == null){
            System.out.println("Something went wrong");
            return;
        }

	    double[][] c;
	    c = multiply(a, b);

	    System.out.println("\n--------------Result-----------------------------------");
        outputMatrix(a, "A");
        outputMatrix(b, "B");
        outputMatrix(c, "C = A * B");

        double sumOfMinElemInCol = getSumOfMinElemInCol(c);
        System.out.println("Sum of minimum element in columns:\n" + sumOfMinElemInCol);
    }
}