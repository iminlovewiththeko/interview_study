public class TwoDPrintDiagonal {

  public static void PrintDiagonal(int[][] arr) {
    int line = arr[0].length + arr.length - 1;
    int x = 0, y = 0;
    int x1 = 0, y1 = 0;
    for (int i = 0; i < line; i++) {
      int curX = x;
      int curY = y; 
      while (curX >= x1 && curY <= y1) {
        System.out.print(arr[curX][curY] + " ");
        curX--;
        curY++;
      }
      if (x < arr.length - 1) {
        x++; 
      } else {
        x = arr.length - 1;
        y++;
      }
      if (y1 < arr[0].length - 1) {
        y1++; 
      } else {
        x1++;
        y1 = arr[0].length - 1;
      }
      System.out.print("\n");
    }
  }

  public static void main(String[] args) {
    /*
    int[][] arr = {
      {1, 2, 3},
      {4, 5, 6},
      {7, 8, 9}
    };*/
    int[][] arr = {
      {1, 2, 3, 4},
      {5, 6, 7, 8},
      {9, 10, 11, 12},
    };

    PrintDiagonal(arr);
  }
}
