public class PrettyPrintNumber {

  public static String TranslateCount(int count) {
    switch (count) {
      case 1:
        return "KB";
      case 2:
        return "MB";
      case 3:
        return "GB";
      case 4:
        return "TB";
      default:
        return "";  
    }
  }

  public static String PrintNum(int num) {
    int count = 0;
    int quotient = 0;
    while (num >= 1000) {
      quotient = num / 1000;
      int remainder = num % 1000;
      if (quotient > 0) {
        count++;
      }
      num = quotient;
    }
    return quotient + TranslateCount(count);
  }

  public static void main(String[] args) {
    System.out.println("1000 -> " + PrintNum(1000));
    System.out.println("999999 -> " + PrintNum(999999));
    System.out.println("10000000 -> " + PrintNum(10000000));
  }
}
