import java.util.*;

public class Trie {
  class Node {
    char value;
    HashMap<Character, Node> adjs;
    boolean is_leaf = false;
    public Node() {
      this.adjs = new HashMap<Character, Node>();
    }
    public Node(char value) {
      this.value = value;
      this.adjs = new HashMap<Character, Node>();
    }

  }
  private Node root;
  public Trie() {
    this.root = new Node();
  }

  public void insert(String str) {
    Node cur = root;
    for (int i = 0; i < str.length(); i++) {
      Character curChar = new Character(str.charAt(i));
      if (cur.adjs.containsKey(curChar)) {
        cur = cur.adjs.get(curChar);
      } else {
        Node next = new Node(str.charAt(i));
        cur.adjs.put(curChar, next);
        cur = next;
      }
      if (i == str.length() - 1) {
        cur.is_leaf = true;
      }
    }
  }

  public boolean search(String word) {
    Node cur = root;
    for (int i = 0; i < word.length(); i++) {
      Character curChar = new Character(word.charAt(i));
      if (cur.adjs.containsKey(curChar)) {
        cur = cur.adjs.get(curChar);
        if (i == word.length() - 1 && cur.is_leaf) {
          return true;  
        }
      }
    }
    return false;
  }

  public boolean startsWith(String prefix) {
    
    return false;
  }

  public static void main(String[] args) {
    Trie t = new Trie();
    t.insert("abc");
    t.insert("abde");
    System.out.println(t.search("abc"));
    System.out.println(t.search("abde"));
  }

}
