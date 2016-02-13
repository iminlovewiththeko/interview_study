import java.util.*;

public class TextJustification {

  public static void PrintTextJustification(String[] words, int length) {
    List<String> list = new ArrayList<String>();
    int curLength = 0;
    int i = 0;
    while (i < words.length) {
      if (curLength + words[i].length() <= length) {
        list.add(words[i]);
        curLength += words[i].length() + 1;
        i++;
      } else {
        // Go do the formatting for the words 
        FormatLine(list, length, false);
        curLength = 0;
        list.clear();
      }
    }  
    if (list.size() > 0) {
      FormatLine(list, length, true);
    }
  }

  public static void FormatLine(List<String> list, int length, boolean last) {
    int ll = 0;  
    for (String l : list) {
      ll += l.length();
    }
    int totalSpaces = length - ll;
    int spaces = totalSpaces, rem = 0;
    if (list.size() > 1) {
      spaces = totalSpaces / (list.size() - 1);
      rem = totalSpaces % (list.size() - 1);
    }

    if (last) {
      spaces = list.size() - 1;
    }

    String result = "";
    for (String l : list) {
      result += l;
      for (int i = 0; i < spaces; i++) {
        result += " ";  
      }
      if (rem > 0) {
        result += " ";
        rem--;
      }
    }
    System.out.println(result);  
  }

  public static void main(String[] args) {
    String[] words = {"This", "is", "an", "example", "of", "text", "justifi"};
    PrintTextJustification(words, 10);
  }
}
