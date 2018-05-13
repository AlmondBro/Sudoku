import java.io.*;
import java.util.Scanner;

public class SudokuDriver
{
    private Sudoku sudoku; 

    public SudokuDriver() {
      sudoku = new Sudoku();
    }

    public Sudoku getSudoku() 
    {
        return this.sudoku;
    }

    public void setSudoku(Sudoku newSudoku) 
    {
        this.sudoku = newSudoku;
    }

    public void load(String filename)  
    {
        Scanner fileReader = null;
        int[][] loadedBoard = new int[9][9]; 
        try {
            fileReader = new Scanner(new FileReader(filename));
            while(fileReader.hasNext())
            {
                //System.out.println("Current Character:\t" + fileReader.next() );
                for (int i = 0; i < loadedBoard.length; i++) 
                {
                    for (int j = 0; j < loadedBoard[i].length; j++) 
                    {
                        
                        loadedBoard[i][j] = Integer.parseInt(fileReader.next());;
                    } //end inner for-loop
                } //end outer for-loop
                this.getSudoku().setBoard(loadedBoard);
            } //end while loop

            //fileReader.close();
        } //end try
        catch (FileNotFoundException e)
        {
            System.out.print("Error opening input file -- file not found exception");
            System.exit(-1);
        }
        catch(NullPointerException e) 
        {
            int[][] newBoard = new int[][]{ {1,2,3,5,6,7,8, 9},
            {1,2,3,5,6,7,8, 9}, {1,2,3,5,6,7,8, 9}, {1,2,3,5,6,7,8, 9},
            {1,2,3,5,6,7,8, 9}, {1,2,3,5,6,7,8, 9}, {1,2,3,5,6,7,8, 9}, {1,2,3,5,6,7,8, 9},
            {1,2,3,5,6,7,8, 9}  };
            this.getSudoku().setBoard(newBoard);
        } 
        
    }  //end load() method

    /* TODO: 
    The user will also want to know if the current board is correct. If the user chooses “complete” command, the
commandline method will call the isComplete method. If every row, column and subgrid is filled in with no invalid
values, then it returns true, and the commandline method prints “true” on the screen. If any values are missing or
invalid, it returns false, and the commandline method prints “false”.
    
    */
    public void commandLine() {
        SudokuDriver sudokuDriver = new SudokuDriver(); 
        Scanner user_input = new Scanner(System.in);
        
        while (true) 
        {
            try 
            {
                int[][] board = sudokuDriver.getSudoku().getBoard();
                System.out.print("> ");
    
                String line = user_input.nextLine();
                String[] t = line.split(" "); //split line
                String cmd = t[0];

                if (cmd.equals("quit")) 
                {   
                    System.out.println("\n Quitting...See you later alligator, in a while crocodile!");
                    user_input.close();
                    break;
                }

                else if (cmd.equals("show"))  
                {   
                    board = sudokuDriver.getSudoku().getBoard();
                    sudokuDriver.getSudoku().show(board); 
                }

                else if (cmd.equals("load"))  
                {   
                    sudokuDriver.load("sudoku.txt");
                    System.out.println("Loaded text file. Enter show to see.");
                }

                else if (cmd.equals("set"))
                {
                    System.out.println("Set called.");

                    int row = Integer.parseInt(t[1]) ;
                    int column = Integer.parseInt(t[2]);
                    int value =  Integer.parseInt(t[3]);

                    //Decrement row and column values by one since Java arrays are 0-indexed.
                    row--;
                    column--;

                    boolean rcheck = sudoku.checkRowConstraints(row, value);
                    boolean ccheck = sudoku.checkColumnConstraints(column, value);
                    boolean scheck = sudoku.checkSubgridConstraints(row, column, value);

                if (rcheck && ccheck && scheck) 
                {   
                        System.out.println("Correct value to insert! You passed all the checks.");
                        //sudokuDriver.getSudoku().insert(row, column, value);
                } 

                else 
                {
                        System.out.println("Error message");
                } //end else-statement 
                    sudokuDriver.getSudoku().insert(row, column, value);
                } //end else-if

                else 
                {
                    System.out.println("Please enter load, show, complete, set, or quit.");
                } 
            } //end try block
            catch(ArrayIndexOutOfBoundsException e) 
            {
                System.out.println("Please provide more arguments for the set command." + 
                " You need to input the row, column, and desired value.");
            } //end catch-block

            catch(NumberFormatException e) 
            {
                System.out.println("Please only input numbers from 1 to 9.");
            } //end catch-block
        } //end while loop
    } //end commandLine() method

    public static void main(String[]args)
    {
        /*
            To run, paste in command line:
                javac SudokuDriver.java; java SudokuDriver
        */
        SudokuDriver sudokuDriver = new SudokuDriver(); 
        
        sudokuDriver.commandLine();
        System.exit(0);
    } //end main() method
} //end SudokuDriver class