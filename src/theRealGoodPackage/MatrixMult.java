package theRealGoodPackage;

import java.util.Scanner;

public class MatrixMult {
	
	//Sample matrix for testing purposes
	/*
	static int[][] a = {
			{1, 2, -2, 0},
			{-3, 4, 7, 2},
			{ 6, 0, 3, 1}
	};
	
	static int[][] b = {
			{-1, 3},
			{0, 9},
			{1, -11},
			{4, -5}
	};
	*/
	
	//Matrix parameters, set by user input in main
	static int arow;
	static int acol;
	static int brow; 
	static int bcol;
	
	//Accepts two matrices as arguments and multiplies them.
	public static int[][] mult(int[][] a, int[][] b)
	{
		//creates matrix c, to store the product of matrices a and b
		int [][] c = new int[arow][bcol];
		
		System.out.println();
		System.out.println("The product matrix is: ");
		
		//Three nested for loops calculate the matrix product. The first iterates through rows, the second through columns, and the third sums the components of the product matrix value
		for (int i = 0; i < arow; i++) {
	           for (int j = 0; j < bcol; j++) {
	               for (int k = 0; k < acol; k++) {
	                  c[i][j] += a[i][k] * b[k][j];
	                   
	               }
	              //updates the relevant value of the product matrix (c) and prints it to the console
	              int x = c[i][j];
                  System.out.print(x + "    ");
	           }
	           //goes the the next line of the printed matrix
	          System.out.println();
	       }
		
		 return c;
	}
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner one = new Scanner(System.in);
		
		//Receives user input for the parameters of the component matrices
		System.out.println("Number of rows in the first matrix: ");
		arow = one.nextInt();
		System.out.println("Number of columns in the first matrix: ");
		acol = one.nextInt();
		System.out.println("Number of rows in the second matrix: ");
		brow = one.nextInt();
		System.out.println("Number of columns in the second matrix: ");
		bcol = one.nextInt();
		
		//creates the component matrices from the parameters accepted above
		int [][] aa = new int[arow][acol];
		int [][] bb = new int[brow][bcol];
		
		//throws and exception if the matrices dimensions make them un-multipliable
		if (acol != brow) {
            throw new IllegalArgumentException("Number of columns in matrix A (" + acol + ") did not match the number of rows in B (" + brow + ").");
        }
		
		//takes user input for the values of every index of matrix a
		for (int i = 0; i < arow; i++) {
	           for (int j = 0; j < acol; j++) {
	        	   System.out.println("Value at " + (j+1) + ", " + (i+1) + " of matrix a: ");
	       			int brocoli = one.nextInt();
	       			aa[i][j] = brocoli;
	           }
		}
		
		//takes user input for the values of every index of matrix b
		for (int i = 0; i < brow; i++) {
	           for (int j = 0; j < bcol; j++) {
	        	   System.out.println("Value at " + (j+1) + ", " + (i+1) + " of matrix b: ");
	       			int brocoli = one.nextInt();
	       			bb[i][j] = brocoli;
	           }
		}
		
		//calls the multiplying function, passing it the two matrices created on lines 68 and 69 as arguments
		mult(aa, bb);
		//closes scanner as it is no longer needed
		one.close();
	}
}
