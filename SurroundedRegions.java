public class SurroundedRegions {
  private int[][] board;
  private boolean[][] visited;
  public SurroundedRegions(int[][] board) {
    this.board = board;
  }

  public void printBoard() {
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        System.out.print(board[i][j] + " ");
      }
      System.out.println("\n");
    }
  }

  public void Solve() {
    int m = board.length;
    int n = board[0].length;
    for (int i = 0; i < m; i++) {
      if (board[i][0] == 0) {
        Merge(i, 0);
      }
      if (board[i][n - 1] == 0) {
        Merge(i, n - 1);
      }
    }

    for (int i = 0; i < n; i++) {
      if (board[0][i] == 0) {
        Merge(0, i);
      }
      if (board[m - 1][i] == 0) {
        Merge(m - 1, i);
      }
    }

    
  }

  public void Merge(int x, int y) {
    if (x < 0 || x > board.length - 1 || y < 0 || y > board[0].length - 1) {
      return;
    }

    if (board[x][y] != 0) {
      return;  
    }

    board[x][y] = 2;
    Merge(x - 1, y);
    Merge(x + 1, y);
    Merge(x, y - 1);
    Merge(x, y + 1);
  }


  public static void main(String[] args) {

  }

}
