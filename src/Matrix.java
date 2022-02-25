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
