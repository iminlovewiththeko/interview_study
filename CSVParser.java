import java.util.*;

public class CSVParser {

  public CSVParser(String[] lines) {
    this.lines = lines;
  }

  public ArrayList<String> ParseCommas(String line) {
    ArrayList<String> results = new ArrayList<String>();
    boolean insideQuote = false;
    int lastIndex = 0;
    for (int i = 0; i < line.length(); i++) {
      if (line.charAt(i) == ',' && !insideQuote) {
        results.add(line.substring(lastIndex, i));
        lastIndex = i+1;
      }
      else if (line.charAt(i) == '"') {
        if (insideQuote) {
          if (i == line.length()-1 || line.charAt(i+1) == ',') {
            results.add(line.substring(lastIndex, i+1));
            lastIndex = i + 2;
            i++;
            insideQuote = false;
          } 
        } else {
          insideQuote = true;
        }
      }
    }
    if (lastIndex < line.length()) {
      results.add(line.substring(lastIndex, line.length()));
    }
    return results;
  }

  public String PrintString(ArrayList<String> eachLine) {
    String concat = "";
    for (String each : eachLine) {
      concat += StripQuotes(each) + "|";
    }
    return concat;
  }

  /*
  public String StripQuotes(String str) {
    boolean foundStart = false, foundEnd = false;
    String front = "", back = "";
    String result = str;
    int i = 0, j = str.length() -1;
    while (i < str.length() && j >= 0) {
      if (str.charAt(i) == '"') {
        foundStart = true;
      }
      if (str.charAt(j) == '"') {
        foundEnd = true;
      }
      if (foundStart && foundEnd) {
        System.out.println("i: " + i);
        System.out.println("j: " + j);
        System.out.println("curent: " + str.substring(1, str.length()-1));
        if (str.charAt(i+1) == '"' || str.charAt(j-1) == '"') {
          return front + '"' + StripQuotes(str.substring(i+1, j)) + back;
          int index = (i - 1 < 0) ? 0 : i - 1;
          return str.substring(0, index) + '"' + StripQuotes(str.substring(i+1, j)) + '"' + str.substring(j+1, str.length());
        } else {
          return front + StripQuotes(str.substring(i+1, j)) + back;
          int index = (i - 1 < 0) ? 0 : i - 1;
          return str.substring(0, index) + StripQuotes(str.substring(i+1, j)) + str.substring(j+1, str.length());
        }
      }
      if (!foundStart) {
        front += str.charAt(i);
        i++;
      }
      if (!foundEnd) {
        back += str.charAt(j) + back;
        j--;
      }
    }
    return result;
  }*/

  public String StripQuotes(String str) {
    String result = "";
    for (int i = 0; i < str.length(); i++) {
      if (str.charAt(i) == '"') {
        if (i < str.length()-1 && str.charAt(i+1) == '"') {
          result += '"';
          i++;
        }
      } else {
        result += str.charAt(i);
      }
    }
    return result; 
  }

  public void ParseStrings() {
    if (lines.length == 0) return;

    for (String line : lines) {
      System.out.println("Original: " + line);
      ArrayList<String> eachLine = ParseCommas(line);
      System.out.println(PrintString(eachLine));
    }
  }

  private String[] lines;

  public static void main(String[] args) {
    String[] examples = {
      "John,Smith,john.smith@gmail.com,Los Angeles,1",
      "Jane,Roberts,janer@msn.com,\"San Francisco, CA\",0",
      "\"Alexandra \"\"Alex\"\"\",Menendez,alex.menendez@gmail.com,Miami,1",
      "\"\"\"Alexandra Alex\"\"\""
    };
    CSVParser parser = new CSVParser(examples);
    parser.ParseStrings();
  }
}
