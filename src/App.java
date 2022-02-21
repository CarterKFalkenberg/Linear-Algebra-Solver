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
        while (!validRowColNum(rowStr, min, max)){
            System.out.println("Invalid. Please try again");
            rowStr = scan.nextLine();
        }
        rows = Integer.parseInt(rowStr);

        // get col #
        String colStr;
        System.out.println("How many columns would you like?. Minimum: " + min + ", Maximum: " + max);
        colStr = scan.nextLine();
        while (!validRowColNum(colStr, min, max)){
            System.out.println("Invalid. Please try again");
            colStr = scan.nextLine();
        }
        cols = Integer.parseInt(colStr);

        /*
        * GET THE CONTENTS OF THE MATRIX
        */

        // row by row
        System.out.println("Enter each row of the matrix. Separate each number by a space. \n Only enter decimals, not fractions!");
        for (int i = 0; i < rows; i++){
            
            // for now, we will use while true
            while (true){

            // get input from user
            String userRow = scan.nextLine();

            // if valid input:
            
                // send information to Matrix.java
                break;
            // else try again, but do not go to next i/row in the for loop
                // therefore, we must have a separate loop that determines when to go to the next i/row
            }

        }



        /*
        * REDUCE AND DISPLAY THE MATRIX
        */

        // display reduced matrix


        scan.close();
    }


    // determines whether a string is a valid entry for row # or col #
    public static boolean validRowColNum(String str, int min, int max){
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
