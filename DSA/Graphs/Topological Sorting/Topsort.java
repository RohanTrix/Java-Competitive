package Graphs;
import java.util.*;
public class Topsort {
  // Adjaceny List
  public Map<Integer, Set<Integer>> edges = new TreeMap<>();
  // Visited Set
  public static Set<Integer> visited = new HashSet<Integer>();
  public static ArrayDeque<Integer> stack = new ArrayDeque<Integer>();
  public static void main(String[] args)
  {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the number of nodes:");
    int n = sc.nextInt();
    System.out.println("Enter the number of edges:");
    int m = sc.nextInt();
    Topsort g = new Topsort();
    for(int i =1; i<=n;i++)
    {
      g.addNode(i);
    }
    for(int i =0; i< m;i++)
    {
      g.addEdge(sc.nextInt(), sc.nextInt());
    }
    g.topsort(n);
    for(int i: stack)
    System.out.print(i+" ");
    sc.close();
  }
  void topsort(int n)
  {
    for(int i =1; i<=n;i++)
    {
        if(!visited.contains(i))
        dfs(i);
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
    stack.offerFirst(v);
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
    edges.get(u).add(v);
  }

  public void removeEdge(int u, int v) {
    edges.get(u).remove(v);
  }
}