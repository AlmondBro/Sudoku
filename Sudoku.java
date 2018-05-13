import java.io.*;
import java.util.Scanner;
public class Sudoku
{
    public static final int SUDOKU_ROWS = 9; //constants
    public static final int SUDOKU_COLUMNS = 9;
    private int[][] board = new int[SUDOKU_ROWS][SUDOKU_COLUMNS];

    /**
     * Constructor for the Sudoku class.
     */
    public Sudoku() {}

    public void show(int[][] board) 
    {
        System.out.print("  ");
         for(int i = 1;i <= 9; i++)
            {
                System.out.print(i+" ");
                if(i == 3 || i == 6)
                {
                    System.out.print("   ");
                } //end if-statement
            } //end for-loop
            System.out.println(); //line break
        for(int i = 0; i < board.length; i++)
        {
            if(i==3 || i==6)
            {
                System.out.print(" ======  | ====== | ======");
                System.out.println();
            } //end if-statement

            System.out.print( (i+1) +" ");  
            for(int j = 0; j < board[i].length; j++)
            {
                System.out.print(board[i][j] + " ");
                if(j == 2 || j == 5)
                {
                    System.out.print(" | ");
                } //end if-statement
            } //end for-loop
            System.out.println("");
} //end outer for-loop
    }

    public int[][] getBoard()  
    {
        return this.board;
    }


    public boolean insert(int row, int col, int value) 
    {
        return false;
    }

    public boolean checkRowConstraints(int row, int value) 
    {
        return true;
    }

    public boolean checkColumnConstraints(int col, int value) 
    {
        return true;
    }

    public boolean checkSubgridConstraints(int row, int col, int value) 
    {
        return true;
    }
} //end Sudoku class
