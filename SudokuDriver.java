import java.io.*;
import java.util.Scanner;

public class SudokuDriver
{
    public SudokuDriver() {}

    public static void load(String filename) {}

    public static void commandline() {}



    public void load(String filename)
    {
        Scanner fin = null;
        try
        {
            fin = new Scanner(new FileReader(filename));
            fin.close();
        }
        catch (Exception e)
        {
            System.out.print("Error opening input file");
            System.exit(0);
        }
    }  

    public static void main(String[]args)
    {
        Scanner input = new Scanner(System.in);
        
        show(board);

        input.close();

        SudokuDriver sudoDriver = new SudokuDriver(); 
        sudoDriver.load("sudoku.txt");   
    } //end main() method
} //end SudokuDriver class