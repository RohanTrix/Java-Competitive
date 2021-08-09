
import java.util.*;
import java.io.*;
public class SCC_Kosaraju {
  // Adjaceny List
  public Map<Integer, Set<Integer>> edges = new TreeMap<>();
  // Visited Set
  public static Set<Integer> visited = new HashSet<Integer>();
  // Stack for storing Topological Ordering in First Pass
  public static List<Integer> stack = new ArrayList<>();
  public static void main(String[] args)
  {
    FastReader sc=new FastReader();
    System.out.println("Enter the number of nodes:");
    int n = sc.nextInt();
    System.out.println("Enter the number of edges:");
    int m = sc.nextInt();
    Kosaraju g = new Kosaraju();
    Kosaraju rev_g = new Kosaraju();
    for(int i =1; i<=n;i++)
    {
      g.addNode(i);
      rev_g.addNode(i);
    }
    for(int i =0; i< m;i++)
    {
        int a = sc.nextInt(); int b = sc.nextInt();
      g.addEdge(a, b);
      rev_g.addEdge(b, a);
    }
    // FIRST-PASS
    for(int i =1; i<=n;i++)
    {
        if(!visited.contains(i))
            g.dfs(i);
    }
    // SECOND-PASS....now operate on reverse graph
    visited.clear();
    int i=0,cnt=0;
    while(stack.size()!=0)
    {
        i = stack.remove(stack.size()-1);
        if(!visited.contains(i)){
            rev_g.dfs2(i);
            cnt+=1;
        }
    }
    sc.print(cnt);
    sc.closer();
  }
  void dfs(int v) // DFS for first pass- Similar for Topological Sorting
  {
    if(visited.contains(v))
        return;
    visited.add(v);
    for(int u : edges.get(v))
        {
            dfs(u);
        }
    stack.add(v);
  }
  void dfs2(int v) // DFS ON Reverse Graph with popping of elemts from stack
  {
    if(visited.contains(v))
    {
        stack.remove(stack.size()-1);
        return;
    }
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
    edges.get(u).add(v);
  }

  public void removeEdge(int u, int v) {
    edges.get(u).remove(v);
  }
}