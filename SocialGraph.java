import java.util.*;

public class SocialGraph {
  class Node {
    boolean visited = false;
    public List<Node> incoming;
    public List<Node> outgoing;
    String value;
    public Node(String value) {
      this.value = value;
      this.incoming = new ArrayList<Node>();
      this.outgoing = new ArrayList<Node>();
    }

    public void addEdge(Node n) {
      if (n == null) return;
      this.outgoing.add(n);
      n.incoming.add(this);
    }
  }

  class Graph {
    List<Node> nodes;        
    Set<Node> candidates;
    public Graph() {
      nodes = new ArrayList<Node>();
      candidates = new HashSet<Node>();
    }

    public void addNode(Node n) {
      nodes.add(n);
    }

    public void DFS(Node cur, Node start) {
      if (start != cur) {
        candidates.remove(cur);  
      }

      if (cur == null || cur.visited) {
        return;
      }
      
      cur.visited = true;
      for (Node neighbor : cur.outgoing) {
        DFS(neighbor, start);
      }  
    }

    public Set<Node> minReach() {
      for (Node n : nodes) {
        if (n.visited == false) {
          candidates.add(n);
          for (Node neighbor : n.outgoing) { 
            DFS(neighbor, n);
          }
        }
      }      
      return candidates;
    }
  }

  public static void main(String[] args) {
    Graph g = new SocialGraph().new Graph();
    Node m = new SocialGraph().new Node("mom");
    Node a = new SocialGraph().new Node("justin biebar");
    Node b = new SocialGraph().new Node("fan1");
    Node c = new SocialGraph().new Node("fan2");
    Node d = new SocialGraph().new Node("fan3");
    m.addEdge(a);
    a.addEdge(b);
    a.addEdge(c);
    a.addEdge(d);

    g.addNode(m);
    g.addNode(a);
    g.addNode(b);
    g.addNode(c);
    g.addNode(d);

    Set<Node> result = g.minReach();
    System.out.println(result.size());
  }

}
