import java.io.*;
import java.util.Scanner;
public class Sudoku
{
    public static final int SUDOKU_ROWS = 9; //constants
    public static final int SUDOKU_COLUMNS = 9;
    private int[][] board;

    /**
     * Constructor for the Sudoku class.
     */
    public Sudoku() {
        board = new int[SUDOKU_ROWS][SUDOKU_COLUMNS];
    }

    public int[][] getBoard()  
    {
        return this.board;
    }

    public void setBoard(int[][] newBoard) 
    {
        this.board = newBoard;
    }
    
    public void insert(int row, int col, int value) 
    {   
        System.out.println("Inserting value...");
        System.out.println("Enter show to see the board with your new value.");
        
        int[][] newBoard = this.getBoard();
        newBoard[row][col] = value;

        this.setBoard(newBoard);
    }

    public boolean checkRowConstraints(int row, int value) 
    {
        board = this.getBoard();
        boolean flag = true; 
        for (int i = 0; i < board.length; i++) 
        {
            if (board[row][i] == value ) {
                flag = false;
            }
        } //end for-loop

        return flag;
    }

    public boolean checkColumnConstraints(int column, int value) 
    {
        board = this.getBoard();
        boolean flag = true; 
        for (int i = 0; i < board.length; i++) 
        {
            if (board[i][column] == value ) {
                flag = false;
            }
        } //end for-loop
        return flag;
    }

    public boolean checkSubgridConstraints(int row, int col, int value) 
    {
        return true;
    }

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

            System.out.print( (i+1) + " ");  
            for(int j = 0; j < board[i].length; j++)
            {
                if (board[i][j] == 0) 
                {
                    System.out.print("_ ");
                }
                else
                {
                    System.out.print(board[i][j] + " ");
                }    
                    
                if(j == 2 || j == 5)
                {
                    System.out.print(" | ");
                } //end if-statement
            } //end for-loop
            System.out.println("");
        } //end outer for-loop
    }

} //end Sudoku class
