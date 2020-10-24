import java.util.*;
public class Graph {
  public Map<Integer, Set<Integer>> edges = new TreeMap<>();
  public static Set<Integer> visited = new HashSet<Integer>();
  void dfs(int v)
  {
    if(visited.contains(v))
      return;
    visited.add(v);
    for(int u : edges.get(v))
    {
      dfs(u);
    }
  }
  public void addNode(int u) {
    if (!edges.containsKey(u)) {
      edges.put(u, new TreeSet<Integer>());
    }
  }
  public void removeNode(int u) {
    if (!edges.containsKey(u)) {
      return;
    }
    for (int v : edges.get(u)) {
      edges.get(v).remove(u);
    }
    edges.remove(u);
  }
  public void addEdge(int u, int v) {
    addNode(u);
    addNode(v);
    edges.get(u).add(v);
    edges.get(v).add(u);
  }

  public void removeEdge(int u, int v) {
    edges.get(u).remove(v);
    edges.get(v).remove(u);
  }

  // Usage example
  public static void main(String[] args) {
    Graph g = new Graph();
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the number of nodes: ");
    int n = sc.nextInt();
    for(int i =0; i< n;i++)
    {
      g.addEdge(sc.nextInt(), sc.nextInt());
    }
    g.dfs(1);
    System.out.println(g.edges);
  }
}

class Pair < X, Y > { // utilizing Java "Generics"
  X x;
  Y y;

  public Pair(X f, Y s) { x = f; y = s; }

  X first() { return x; }
  Y second() { return y; }

  void setFirst(X f) { x = f; }
  void setSecond(Y s) { y = s; }
}