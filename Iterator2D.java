import java.util.*;

public class Iterator2D {
  public Iterator2D(ArrayList<ArrayList<Integer>> lists) {
    this.lists = lists;
  }

  public int next() {
    if (listIndex >= lists.size()) return -1;
    ArrayList<Integer> curList = lists.get(listIndex);
    if (listCounter < curList.size()) {
      return curList.get(listCounter++);
    }
    else {
      listIndex++;
      listCounter = 0;
      if (listIndex >= lists.size()) return -1;
      return lists.get(listIndex).get(listCounter++);
    }
  }

  public boolean hasNext() {
    if (listIndex < this.lists.size()) {
      return true;
    }
    return false;
  }

  private ArrayList<ArrayList<Integer>> lists;
  private int listCounter;
  private int listIndex;

  public static void main(String[] args) {
    ArrayList<Integer> a_list = new ArrayList<Integer>();
    Collections.addAll(a_list, 1, 2, 3);
    ArrayList<Integer> b_list = new ArrayList<Integer>();
    Collections.addAll(b_list, 4, 5, 6);
    ArrayList<ArrayList<Integer>> new_list = new ArrayList<ArrayList<Integer>>();
    new_list.add(a_list);
    new_list.add(b_list);
    
    Iterator2D result = new Iterator2D(new_list);
    while(result.hasNext()) {
      System.out.println(result.next());
    }
  }
}
