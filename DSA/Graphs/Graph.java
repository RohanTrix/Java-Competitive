import java.util.*;
public class Graph {
  // Adjaceny List
  public Map<Integer, Set<Integer>> edges = new TreeMap<>();
  // Visited Set
  public static Set<Integer> visited = new HashSet<Integer>();
  public static void main(String[] args)
  {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the number of edges: ");
    int n = sc.nextInt();
    Graph g = new Graph();
    for(int i =0; i< n;i++)
    {
      g.addEdge(sc.nextInt(), sc.nextInt());
    }
    g.bfs(1);
    System.out.println(g.edges);
  }
  void bfs(int v)
  {
    Queue<Integer> q = new LinkedList<>();
    int distance[] = new int[edges.size()+1];


    visited.add(v);
    distance[v] = 0;
    q.add(v);
    while(q.size()!=0)
    {
      int s = q.poll();
      // Process node s
      for( int u : edges.get(s))
      {
        if(visited.contains(u))
          continue;
        visited.add(u);
        distance[u] = distance[s] + 1;
        q.add(u);
      }
    }
  }
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