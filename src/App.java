import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        System.out.println((int)1.9);
        
        String test = "";
        test.split("\s+");


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

        // initialize matrix
        Matrix matrix = new Matrix(rows, cols);

        /*
        * GET THE CONTENTS OF THE MATRIX
        */

        // row by row
        System.out.println("Enter each row of the matrix. Separate each number by a space. \n Only enter decimals, not fractions!");
        for (int i = 0; i < rows; i++){
            
            // for now, we will use while true
            String userRow = "";
            do{
                
                // get input from user
                userRow = scan.nextLine();

                // if valid input:
                if (validRow(userRow, rows, cols)){
                    // SEND INFORMATION TO MATRIX.JAVA
                    // TO BE DONE NEXT
                }
                else {
                    // invalid entry
                    System.out.println("Invalid entry. Please try again");
                }
            } while(!validRow(userRow, rows, cols));
            matrix.setRow(i+1, userRow);
        }

        // show the user the matrix
        System.out.println("\nOriginal matirx:");
        System.out.println(matrix);

        /*
        * REDUCE AND DISPLAY THE MATRIX
        */
        matrix.reduce();

        // display reduced matrix
        System.out.println("Reduced matrix:");
        System.out.println(matrix);

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

    // determines whether a string is a valid entry for a row in the matrix
    public static boolean validRow(String str, int rows, int cols){
        
        // immediate indicator as to whether string is valid
        if (str.length() < (cols * 2) - 1){
            return false;
        }

        // split each entry by a space. The # of entries should be the same as the # of cols
        String[] entries = str.split("\s+");
        if (entries.length != cols){
            return false;
        }

        // make sure each entry is a valid numer
        for (String entry : entries){
            try{
                double i = Double.parseDouble(entry);
            } catch(NumberFormatException e){
                return false;
            }
        }

        return true;
    }
}
