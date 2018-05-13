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

    public void show() 
    {

    }

    public boolean insert(int row, int col, int value) 
    {
        return false;
    }

    public boolean checkRowConstraints(int row, int value) {
        return true;
    }

    public boolean checkColConstraints(int col, int value) {

    }

    public boolean checkSubgridConstraints(int row, int col, int value) 
    {

    }
} //end Sudoku class
