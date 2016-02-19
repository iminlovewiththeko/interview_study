public class BlackSmallestRectangle {

  public int left;
  public int right;
  public int top;
  public int down;
  public int maxArea;
  public int[][] image;

  public BlackSmallestRectangle(int[][] image) {
    this.image = image;
  }
  public int minArea(int x, int y) {
    this.left = y;
    this.right = y;
    this.top = x;
    this.top = x;

    boolean[][] visited = new boolean[image.length][image[0].length];
    GetRectArea(x, y, visited);
    return maxArea;
  }

  public void GetRectArea(int x, int y, boolean[][] visited) {
    if (x < 0 || x > image.length - 1 || y < 0 || y > image[0].length - 1 || visited[x][y] == true) return;

    if (image[x][y] == 0) return;

    visited[x][y] = true;

    left = Math.min(left, x);
    right = Math.max(right, x);
    top = Math.min(top, y);
    down = Math.max(down, y);

    int area = (right - left + 1) * (down - top + 1);
    maxArea = Math.max(area, maxArea);

    GetRectArea(x + 1, y, visited);
    GetRectArea(x - 1, y, visited);
    GetRectArea(x, y - 1, visited);
    GetRectArea(x, y + 1, visited);
  }

  public static void main(String[] args) {
    int[][] image = {
      {0, 0, 1, 0},
      {0, 1, 1, 0},
      {0, 1 ,0, 0},
    };
    BlackSmallestRectangle r = new BlackSmallestRectangle(image);
    System.out.println(r.minArea(1, 2));
  }
}
