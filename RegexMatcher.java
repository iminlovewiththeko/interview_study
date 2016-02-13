public class RegexMatcher {

  /*
  public static boolean CheckMatch(String pattern, String word, String prev) {
    if (word.length() == 0) {
      return (pattern.length() == 0) ? true : false;
    }
    if (pattern.length() == 0) return false;

    char curChar = word.charAt(0);
    char curPat = pattern.charAt(0);
    if (pattern.length() > 1 && pattern.charAt(1) == '*') {
      prev = pattern.substring(0, 1);
    }
    if (curPat == '*') {
      System.out.println("prev: " + prev);
      System.out.println("word: " + word);
      if (word.length() == 1 && pattern.length() == 1) {
        return prev == word;
      }
      return CheckMatch(pattern.substring(1), word, "") || CheckMatch(pattern, word.substring(1), prev);
    } else if (curPat == '.') {
      return CheckMatch(pattern.substring(1), word.substring(1), prev);
    } else if (curPat == curChar) {
      return CheckMatch(pattern.substring(1), word.substring(1), prev);
    }
    return false;
  }*/
  
  public static boolean CheckMatch(String pattern, String word) {
    if (word.length() == 0) {
      return (pattern.length() == 0) ? true : false;
    }
    if (pattern.length() == 0) return false;

    char curChar = word.charAt(0);
    char curPat = pattern.charAt(0);
    
    String nextChar = "";
    if (pattern.length() > 1 && pattern.charAt(1) == '*') {
      nextChar = pattern.substring(1, 2);
    }
    
    if (nextChar.equals("*")) {
      if (word.length() == 1 && pattern.length() == 2) {
        return CheckMatch(pattern.substring(0, 1), word);
      }
      if (curPat != '.' && curChar != curPat) {
        return CheckMatch(pattern.substring(2), word);
      }
      return CheckMatch(pattern.substring(2), word) || CheckMatch(pattern, word.substring(1));
    } else if (curPat == '.') {
      return CheckMatch(pattern.substring(1), word.substring(1));
    } else if (curPat == curChar) {
      return CheckMatch(pattern.substring(1), word.substring(1));
    }
    return false;
  }

  public static void main(String[] args) {
    //System.out.println(CheckMatch("abc", "abc", ""));
    //System.out.println(CheckMatch("a*c", "aac", ""));
    //System.out.println(CheckMatch("a*bc", "abc", ""));
    //System.out.println(CheckMatch("a*", "aaa"));
    //System.out.println(CheckMatch(".*", "aa"));
     //= “abbbc”, p = “ab*c”
    System.out.println(CheckMatch("ab*c", "abbbc"));
    System.out.println(CheckMatch("ab*bbc", "abbc"));
  }
}
