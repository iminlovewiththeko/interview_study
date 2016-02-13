public class MinJump {

  public static int minJump(int[] arr, int start, int end) {
    if (arr.length == 0 || arr[0] == 0) return Integer.MIN_VALUE;

    int[] results;
    results[0] = 0;
    for (int i = 1; i < arr.length; i++) {
      results[i] = Integer.MAX_VALUE;
      for (int j = 0; j < i; j++) {
        if (j + arr[j] >= i) {
          if (results[j] != Integer.MAX_VALUE) {
            results[i] = min(results[j] + 1, results[i]);
            break;
          }
        }
      }
    }
  }

  public static void main(String[] args) {

  }
}
