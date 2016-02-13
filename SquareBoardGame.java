import java.util.*;

public class SquareBoardGame {

  public static boolean canWin(int[] board, int pos, Set<Integer> visited) {
    if (board[pos] == 0) return true;
    if (visited.contains(pos)) return false;
    int curVal = board[pos];
    Set<Integer> newVisited = visited;
    boolean win = false;
    if (pos - curVal >= 0) {
      newVisited.add(pos);
      win = canWin(board, pos - curVal, newVisited);
    }
    if (!win && pos + curVal < board.length) {
      newVisited.add(pos);
      win = canWin(board, pos + curVal, newVisited);
    }
    return win;
  }

  public static void main(String[] args) {
    //int[] arr = {1, 3, 2, 0, 1, 2, 8};
    int[] arr = {1, 1};
    Set<Integer> visited = new HashSet<Integer>();
    //System.out.println(canWin(arr, 5, visited));
    System.out.println(canWin(arr, 1, visited));
  }
}
