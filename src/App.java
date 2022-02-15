import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        int min = 1;
        int max = 10;
        int rows, cols;
        Scanner scan = new Scanner(System.in);

        /*
        * GET ROW # and GET COL #. MUST BE INT BETWEEN MIN AND MAX (INCLUSIVE)
        */

        // get row # 
        String rowStr;
        System.out.println("How many rows would you like?. Minimum: " + min + ", Maximum: " + max);
        rowStr = scan.nextLine();
        while (!validRowCol(rowStr, min, max)){
            System.out.println("Invalid. Please try again");
            rowStr = scan.nextLine();
        }
        
        // get col #
        String colStr;
        System.out.println("How many columns would you like?. Minimum: " + min + ", Maximum: " + max);
        colStr = scan.nextLine();
        while (!validRowCol(colStr, min, max)){
            System.out.println("Invalid. Please try again");
            colStr = scan.nextLine();
        }

        // get contents of the matrix, row by row

        // display reduced matrix


        scan.close();
    }


    // determines whether a string is a number
    public static boolean validRowCol(String str, int min, int max){
        if (str == null){
            return false;
        }
        try{
            Integer d = Integer.parseInt(str);
            if (d < min || d > max){
                return false;
            }
        } catch (NumberFormatException nfe){
            return false;
        }
        return true;
    }
}
