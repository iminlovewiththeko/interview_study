import java.util.*;

public class MyAuto {
  class Node {
    char value;
    boolean isLeaf;
    Map<Character, Node> adjs;
    public Node() {
      adjs = new HashMap<Character, Node>();
    }

    public Node(char value) {
      this.value = value;
      adjs = new HashMap<Character, Node>();
    }
  }

  Node root;
  public MyAuto() {
    root = new Node();
  }   

  public void InsertWord(String word) {
    Node cur = root;
    for (int i = 0; i < word.length(); i++) {
      Character curChar = new Character(word.charAt(i));
      if (cur.adjs.containsKey(curChar)) {
        cur = cur.adjs.get(curChar);
      } else {
        Node newNode = new Node(word.charAt(i));
        cur.adjs.put(curChar, newNode);
        if (i == word.length() - 1) {
          newNode.isLeaf = true; 
        } else {
          cur = newNode;
        }
      }
    }  
  }
  
  public void GetAllStrings(Node n, String prefix, List<String> result, boolean start) {
    if (n.isLeaf) {
      String value = start ? prefix : (prefix + n.value);
      result.add(value);
    }
    for (Node neighbor : n.adjs.values()) {
      if (start) {
        GetAllStrings(neighbor, prefix, result, false);
      } else {
        GetAllStrings(neighbor, prefix + n.value, result, false);
      }
    }
  }

  public List<String> GetSuggestions(String prefix) {
    List<String> result = new ArrayList<String>();
    if (prefix == null || prefix.length() == 0) {
      return result;
    }
    Node cur = root;
    String strSoFar = "";
    for (int i = 0; i < prefix.length(); i++) {
      Character curChar = new Character(prefix.charAt(i));
      if (cur.adjs.containsKey(curChar)) {
        cur = cur.adjs.get(curChar);
        strSoFar += curChar;
      }
    }
    //System.out.println("sofar: " + strSoFar);
    GetAllStrings(cur, strSoFar, result, true);
    return result; 
  }


  public static void main(String[] args) {
    MyAuto trie = new MyAuto(); 
    trie.InsertWord("abcd");
    trie.InsertWord("abce");
    trie.InsertWord("abde");
    trie.InsertWord("abbe");
    trie.InsertWord("abfce");
    trie.InsertWord("abe");
    trie.InsertWord("ab");
    trie.InsertWord("b");
    trie.InsertWord("ba");
    List<String> result = trie.GetSuggestions("b");
    for (String s : result) {
      System.out.println(s);
    }
  }

}
