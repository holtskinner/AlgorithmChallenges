public class EightQueens {

  public static void main() {

    int SIZE = 8; // CHangeable for anysize chesschessBoard

    int[][] chessBoard = new int[SIZE][SIZE]; //Initialize empty chessBoard

    solve(0, chessBoard, SIZE); //Starts the whole shebang with the first row

    //This just prints the board
    for(int i = 0; i < SIZE; i++) {
      for(int j = 0; j < SIZE; j++) {
        if(chessBoard[i][j]==1) System.out.print("Q ");
        else System.out.print("* ");
      }
      System.out.println(); //This is here to add a new line for each row of the board
    }
  }

  static boolean solve(int row, int[][] chessBoard, int SIZE) {

    if(row >= SIZE) { //If we hit the end of the board
      return true;
    }
    //position- cycles through all y spots in array
    for(int position = 0; position < SIZE; position++) {

      if(isValid(chessBoard, row, position, SIZE) == true) { //If you can place a queen at current location, do it
        chessBoard[row][position] = 1; //Place queen

        if(solve(row+1, chessBoard, SIZE) != false) { //If we can't place a queen at a location
          chessBoard[row][position] = 0;//empty space
        } else
          return true; //Base case, end recursive call at this spot
      }

    }
    return false; //End recursive call
  }

  //x and y are the spot we're checking if you can put a queen there.
  static boolean isValid(int[][] chessBoard, int x, int y, int SIZE) {
    int i, j;
    //Checking all elements in a particular row
    for(i = 0; i < x; i++) {
      if(chessBoard[i][y]==1) {
        return false;
      }
    }

    //Checking -1 diagonal
    i = x - 1;
    j = y - 1;
    while((i >= 0) && (j >= 0)) {
      if(chessBoard[i][j] == 1) {
        return false;
      }
      i--;
      j--;
    }

      //Checking +1 diagonal
    i = x - 1; //minus 1 because arrays start at zero and everything is off by one
    j = y + 1;
    while( (i >= 0) && (j < SIZE) ) { //check to see that i & j don't go off the end of the board
      if(chessBoard[i][j] == 1) { //if theres a queen somewhere in the diagonal, tell the solve function to not put a queen in the spot we are trying to put one
        return false;
      }
      i--; //i and j are changed differently because we are going in the "upward diagonal", up and to the right
      j++;
    }

    return true;
  }
