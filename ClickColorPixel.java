public class ClickColorPixel {
  public static void ChangeColor(char[][] image, int x, int y, char target, boolean[][] visited) {
    if (x < 0 || x > image.length - 1 || y < 0 || y > image[0].length || visited[x][y]) {
      return;
    }

    if (target == image[x][y]) return;

    image[x][y] = (image[x][y] == 'W') ? 'B' : 'W';
    visited[x][y] = true;

    ChangeColor(image, x - 1, y, target, visited);
    ChangeColor(image, x + 1, y, target, visited);
    ChangeColor(image, x, y - 1, target, visited);
    ChangeColor(image, x, y + 1, target, visited);
  }

  public static void PrintImage(char[][] img) {
    for (int i = 0; i < img.length; i++) {
      for (int j = 0; j < img[0].length; j++) {
        System.out.print(img[i][j] + " ");
      }
      System.out.println("\n");
    }
  }

  public static void main(String[] args) {
    char[][] arr = {
      {'W', 'B', 'W', 'W', 'B', 'W'},
      {'B', 'B', 'W', 'W', 'B', 'W'},
      {'W', 'B', 'B', 'B', 'W', 'B'},
      {'W', 'B', 'W', 'W', 'B', 'B'},
    };
    boolean[][] visited = new boolean[arr.length][arr[0].length];

    ChangeColor(arr, 2, 2, 'W', visited);
    PrintImage(arr);
  } 
}
