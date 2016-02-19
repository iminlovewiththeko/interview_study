public class MinMax {
  class Pair {
    int min;
    int max;
    public Pair(int min, int max) {
      this.min = min;
      this.max = max;
    }
  }

  public static void FindMinMax(int[] arr) {
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;
    int i = 0;
    for (i = 0; i < arr.length; i = i + 2) {
      if (arr[i] < arr[i+1]) {
        if (arr[i] < min) {
          min = arr[i];
        }
        if (arr[i+1] > max) {
          max = arr[i+1];
        }
      } else {
        if (arr[i] > max) {
          max = arr[i];
        }
        if (arr[i+1] < min) {
          min = arr[i+1];
        }
      }
    }
    if (i < arr.length) {
      if (arr[i] < min) {
        min = arr[i];
      } else if (arr[i] > max) {
        max = arr[i];
      }
    }
    System.out.println("min: " + min);
    System.out.println("max: " + max);
  }

  public static void main(String[] args) {
    int[] arr = {2, 1, -1, 10, 20, 50};
    FindMinMax(arr);
  }

}
