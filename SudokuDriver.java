public class SudokuDriver
{
    public static void load(String filename)
    {
        Scanner fin = null;
        try
        {
            fin = new Scanner(new FileReader(filename));
        }
        catch (Exception e)
        {
            System.out.print("Error opening input file");
            System.exit(0);
        }
    }
} //end SudokuDriver() class