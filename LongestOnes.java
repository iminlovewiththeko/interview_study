public class LongestOnes {


  public static int GetIndex(int[] arr) {
    int maxCount = 0;
    int maxIndex = 0;
    int prevIndex = -1;
    int prevPrevIndex = -1;

    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == 0) {
        if (i - prevPrevIndex > maxCount) {
          maxCount = i - prevPrevIndex;
          maxIndex = prevIndex;    
        }
        prevPrevIndex = prevIndex;
        prevIndex = i;
      }
    }
    if (arr.length - prevPrevIndex > maxCount) {
      maxIndex = prevIndex;    
    }

    return maxIndex;
  }

  public static void main(String[] args) {
    int[] arr = {1, 1, 0, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1};
    System.out.println(GetIndex(arr));
  }
}
