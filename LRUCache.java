import java.util.*;

public class LRUCache {
  class Node {
    int key;
    int value;
    Node prev;
    Node next;
    Node (int key, int value) {
      this.key = key;
      this.value = value;
    }
    int GetValue() {
      return value;
    }
    void SetValue(int value) {
      this.value = value;
    }
  }

  public LRUCache(int capacity) {
    map = new HashMap<Integer, Node>();
    this.capacity = capacity;
  }

  public int Get(int key) {
    if (map.containsKey(key)) {
      return map.get(key).GetValue();
    }
    return -1;
  }

  public void SetTail(Node n) {
    Node prev = n.prev;
    Node next = n.next;
    if (tail != null) {
      tail.next = n;
      n.prev = tail;
      n.next = null;
    }
    tail = n;
  }

  public void DeleteNode(Node n) {
    Node prev = n.prev;
    Node next = n.next;
    if (prev != null) {
      prev.next = next;
    } else {
      head = next;
    }

    if (next != null) {
      next.prev = prev;
    }  else {
      tail = prev;
    }
  }

  public void Set(int key, int value) {
    if (map.containsKey(key)) {
      Node curr = map.get(key);
      curr.SetValue(value);
      DeleteNode(curr);
      // Update the tail.
      SetTail(curr);
    } else {
      if (map.size() == capacity) {
        System.out.println("old head key: " + head.key);
        map.remove(head.key);
        DeleteNode(head);
      }
      Node newEntry = new Node(key, value);

      if (map.size() == 0) {
        head = newEntry;
        tail = newEntry;
      } else {
        SetTail(newEntry);
      }
      map.put(key, newEntry);
    }
  }

  private HashMap<Integer, Node> map;
  int capacity = 0;
  private Node head = null;
  private Node tail = null;
  public static void main(String[] args) {
    LRUCache cache = new LRUCache(2);  
    cache.Set(1, 2);
    cache.Set(4, 5);
    cache.Set(2, 3);
    cache.Set(2, 4);
    cache.Set(3, 6);
    System.out.println(cache.Get(1));
    System.out.println(cache.Get(4));
    System.out.println(cache.Get(2));
    System.out.println(cache.Get(3));
  }
}
