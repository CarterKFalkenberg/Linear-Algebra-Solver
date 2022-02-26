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
  public void reduce(){
    
    // start at ri = 0, ci = 0 (r = row INDEX, c = column INDEX)
    int ri = 0;
    int ci = 0;
    // loop while c<cols AND r<rows
    while (ci < cols && ri < rows){
      // 1. find first nonzero element in c such that row >= r
      int currRow = ri;
      int pivotRowIndex;
      while (currRow < rows && this.matrix[currRow][ci] == 0){
        currRow++;
      }
      if (currRow < rows){
        pivotRowIndex = currRow;
      } else{

        // a. if none, check rows < r
        currRow = ri-1;
        while (currRow > -1 && this.matrix[currRow][ci] == 0){
          currRow--;
        }
        if (currRow > -1){
          pivotRowIndex = currRow;
        } else{

          // b. if still none, go to start of loop again with c++ 
          ci++;
          continue;
        }
      }

      // Interchange rows if neccessary (only if the nonzero element is not in row r)
      if (pivotRowIndex != ri){
        double[] temp = this.matrix[ri];
        this.matrix[ri] = this.matrix[pivotRowIndex];
        this.matrix[pivotRowIndex] = temp;
      }
      
      // Scale r such that the pivot = 1 (i.e. the first non-zero element is 1)
      if (this.matrix[ri][ci] != 1){
        double scale = 1.0/this.matrix[ri][ci];
        for (int i = 0; i < cols; i++){
          this.matrix[ri][i] *= scale;
        }
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

      break;

      // Go to start of loop again with ri++ and ci++
      //ri++;
      //ci++;
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

  

}
