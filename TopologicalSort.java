import java.util.*;

public class TopologicalSort {

  class Node {
    Node(List<Node> nodes) {
      this.adj = nodes;  
    }
    List<Node> adj;
    boolean visited = false;
  }

  class Graph {
    public Graph(List<Node> nodes) {
      this.nodes = nodes;   
    }
    List<Node> nodes;
  }

  public static void TopoTraverse(Node current, Stack<Node> stack) {
    if (current == null) return;
    current.visited = true;
    for (Node n : current.adj) {
      if (!n.visited) {
        TopoTraverse(n, stack); 
      }
    }
    stack.push(current);
  }

  public static void DoSort(Graph g) {
    Stack<Node> stack = new Stack<Node>();
    for (Node n : g.nodes) {
      if (!n.visited) {
        TopoTraverse(n, stack);    
      }
    }
  }

  public static void main(String[] args) {
  }
}
