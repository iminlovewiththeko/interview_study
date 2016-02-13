public class MakeChange {

  public static int minChange(int[] coins, int target) {
    if (target == 0) return 0;

    int curMin = Integer.MAX_VALUE;
    for (int each : coins) {
      if (target - each >= 0) {
        int min = 1 + minChange(coins, target - each);
        if (min != Integer.MAX_VALUE && min < curMin) {
          curMin = min;
        }
      }
    }
    return curMin;
  }

  public static void main(String[] args) {
    int[] coins = {5, 10, 25};
    System.out.println(minChange(coins, 15));
    System.out.println(minChange(coins, 25));
    System.out.println(minChange(coins, 3));
  }
}
