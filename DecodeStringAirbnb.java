import java.util.*;

public class DecodeStringAirbnb {

  public static boolean Decode(String str) {
    return false;
  }

  public static List<String> BuildCombination(String str) {
    if (str.length() == 1) {
      List<String> base = Arrays.asList(str.toUpperCase(), str);
      return base;
    }

    char currentChar = str.charAt(0);
    List<String> restComb = BuildCombination(str.substring(1));
    List<String> result = new ArrayList<String>();
    for (String each : restComb) {
      result.add(Character.toUpperCase(currentChar) + each);      
      result.add(currentChar + each);      
    }
    return result;
  }

  public static void main(String[] args) {
    String str = "abc";
    List<String> results = BuildCombination(str);
    System.out.println(results);  
  }
}
