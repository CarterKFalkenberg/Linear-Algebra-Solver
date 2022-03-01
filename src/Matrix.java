import java.util.ArrayList;

public class Matrix {
  
  private double[][] matrix;
  private int rows, cols;

  // constructor to initialize rows, cols of the matrix
  Matrix(int rows, int cols){
    this.rows = rows;
    this.cols = cols;
    this.matrix = new double[rows][cols];
  }


  // method(s) to create the matrix, row by row
  public void setRow(int row, String contents){
    String[] entries = contents.split("\s+");
    for (int i = 0; i < entries.length; i++){
      try{
        this.matrix[row-1][i] = Double.parseDouble(entries[i]);
      } catch (NumberFormatException e){
        e.printStackTrace();
      }
    }
  } 

  // method(s) to reduce the matrix

  // NEED TO HAVE AN IN DEPTH PRINTING SYSTEM SAYING WHAT IS BEING DONE AT EVERY SINGLE STEP TO DEBUG
  // DOES NOT WORK WITH SIMPLE 3x3 123,456,789 MATRIX...

  public void reduce(){
    // start at ri = 0, ci = 0 (r = row INDEX, c = column INDEX)
    int ri = 0;
    int ci = 0;
    // loop while c<cols AND r<rows
    while (ci < cols && ri < rows){
      System.out.println(this);
      // 1. find first nonzero element in c such that row >= r
      int currRow = ri;
      int pivotRowIndex;
      while (currRow < rows && this.matrix[currRow][ci] == 0){
        currRow++;
      }
      if (currRow < rows){
        pivotRowIndex = currRow;
      } else{

        // a. if none, go to start of loop again with c++ 
        System.out.println("COLUMN " + (ci+1) + " DOES NOT HAVE A PIVOT. INCREASING CI");
        ci++;
        continue;
        
      }
      System.out.println("PIVOT ROW IS " + (pivotRowIndex+1));

      // Interchange rows if neccessary (only if the nonzero element is not in row r)
      if (pivotRowIndex != ri){
        System.out.println("EXCHANGING ROWS " + (pivotRowIndex+1) + " AND " + (ri+1));
        double[] temp = this.matrix[ri];
        this.matrix[ri] = this.matrix[pivotRowIndex];
        this.matrix[pivotRowIndex] = temp;
        System.out.println(this);
      }
      
      // Scale r such that the pivot = 1 (i.e. the first non-zero element is 1)
      if (this.matrix[ri][ci] != 1){
        double scale = 1.0/this.matrix[ri][ci];
        System.out.println("SCALING ROW " + (ri + 1) + " BY " + scale);
        for (int i = 0; i < cols; i++){
          // avoid scaling 0 (creates -0)
          if (this.matrix[ri][i] != 0.0){
            this.matrix[ri][i] *= scale;
            
            // round to 2 decimals
            this.matrix[ri][i] = this.round(this.matrix[ri][i]);
          }
        }
        System.out.println(this);
      }

      // Add all non-pivot rows with a scaled r such that their element in column c = 0
      ArrayList<Integer> rowsToBeScaled = new ArrayList<Integer>(); //stores INDEXES of rows that need to be scaled
      for (int i = 0; i < rows; i++){
        if (i == ri){
          continue;
        }
        if (this.matrix[i][ci] != 0){
          rowsToBeScaled.add(i);
        }
      }

      // FOR TESTING PURPOSES ONLY
        String testStr = "ROWS ";
        for (int index : rowsToBeScaled){
          testStr += (index+1) + " ";
        }
        testStr += "NEED TO BE SCALED";
        System.out.println(testStr);
      // END OF TESTING PURPOSES ONLY BLOCK

      for (int index : rowsToBeScaled){
        double scale = -(this.matrix[index][ci]);
        System.out.println("SCALING ROW " + (index+1) + " WITH " + scale + " * ROW " + (ri + 1));
        for (int i = 0; i < cols; i++){
          this.matrix[index][i] = this.matrix[index][i] + scale * this.matrix[ri][i];
          this.matrix[index][i] = round(this.matrix[index][i]);
        }
        System.out.println(this);
      }

      // Go to start of loop again with ri++ and ci++
      ri++;
      ci++;
      ///break;
    }



  }

  // method(s) to print the matrix to the user
  public String toString(){
    String str = "";
    for (double[] row : this.matrix){
      for (double num : row){
        str += num + " ";
      }
      str += "\n";
    }
    return str;
  }

  // takes a double and returns a double rounded to 2 decimal places
  public double round(double num){
    System.out.print(num + " is becoming ");
    num *= 100;
    num = Math.round(num);
    System.out.println((int)num/100.0);
    return (int)(num)/100.0;
  }
}
