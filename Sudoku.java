import java.io.*;
import java.util.Scanner;
public class Sudoku
{
    public static int[][] sudoku= new int[9][9];

    public static void show(int[][] x)
    {
        System.out.print("  ");
         for(int i=1;i<=9;i++)
            {
                System.out.print(i+" ");
                if(i == 3 || i == 6)
                {
                    System.out.print("   ");
                } //end if-statement
            } //end for-loop
            System.out.println(); //line break
        for(int i=0; i<x.length;i++)
        {
            if(i==3 || i==6)
            {
                System.out.print(" ======  | ====== | ======");
                System.out.println();
            } //end if-statement

            System.out.print(i+1+" ");  
            for(int j = 0; j < x[i].length; j++)
            {
                System.out.print(x[i][j] + " ");
                if(j == 2 || j == 5)
                {
                    System.out.print(" | ");
                } //end if-statement
            } //end for-loop
            System.out.println("");
        } //end outer for-loop
    } //end show method

    public static void main(String[]args)
    {
        Scanner input = new Scanner(System.in);
        
        show(sudoku);

        input.close();
        //load("sudoku.txt");
    } //end main() method
}
