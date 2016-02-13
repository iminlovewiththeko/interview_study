public class ShortestDistanceBuilding {

  public static void DoBFS(int[][] land, boolean[][] visited, int[][] counters, int x, int y, int prev) {
    if (visited[x][y] == true || land[x][y] == 2 || land[x][y] == 1) return;
    counters[x][y] = prev + 1;
    int value = prev + 1; 
    visited[x][y] = true;
    System.out.println("x: " + x + " and y: " + y + " value: " + prev);
    if (x -1 >= 0) {
      DoBFS(land, visited, counters, x - 1, y, value);
    }
    if (x + 1 < land.length) {
      DoBFS(land, visited, counters, x + 1, y, value);
    }
    if (y - 1 >= 0) {
      DoBFS(land, visited, counters, x, y - 1, value);
    }
    if (y + 1 < land[0].length) {
      DoBFS(land, visited, counters, x, y + 1, value);
    }
  }

  public static int shortestDist(int[][] land) {
    boolean[][] visited = new boolean[land.length][land[0].length];
    int[][] counters = new int[land.length][land[0].length];

    for (int i = 0; i < land.length; i++) {
      for (int j = 0; j < land[0].length; j++) {
        if (land[i][j] == 1) {
          if (i - 1 >= 0) {
            DoBFS(land, visited, counters, i - 1, j, 0);
          }
          if (i + 1 < land.length) {
            DoBFS(land, visited, counters, i + 1, j, 0);
          }
          if (j + 1 < land[0].length) {
            DoBFS(land, visited, counters, i, j + 1, 0);
          }
          if (j - 1 >= 0) {
            DoBFS(land, visited, counters, i, j - 1, 0);
          }
        }
        break;
      }
    }

    int min = -1;
    for (int i = 0; i < counters.length; i++) {
      for (int j = 0; j < counters[0].length; j++) {
        System.out.print(counters[i][j] + " ");
        if (counters[i][j] != 0 && land[i][j] == 0) {
          min = counters[i][j]; 
        }
      }
      System.out.println("\n");
    }
    return min;
  }

  public static void main(String[] args) {
    int[][] lands = {
      {1, 0, 2, 0, 1},
      {0, 0, 0, 0, 0},
      {0, 0, 1, 0, 0},
    };    
    System.out.println(shortestDist(lands));
  }
}
