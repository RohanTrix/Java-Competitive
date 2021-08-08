import java.util.*;

// REFER : AlgoZenith CP Course
public class BFS_01 {
  // Adjaceny List
  public Map<Integer, ArrayList<Pair>> edges = new TreeMap<>();
  public static void main(String[] args)
  {
    BFS_01 g = new BFS_01();
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter Number of Nodes: ");
    int m = sc.nextInt();
    for(int i = 1; i<=m; i++) g.addNode(m);
    
    System.out.println("Enter Number of Edges: ");
    int n = sc.nextInt();
    
    for(int i =0; i< n;i++)
    {
      g.addEdge(sc.nextInt(), sc.nextInt(), sc.nextInt());
    }
    //System.out.println(g.edges);
    g.bfs01(1);
    
    sc.close();
  } 
  void bfs01(int v)
  {
    ArrayDeque<Integer> dq = new ArrayDeque<>();
    int distance[] = new int[edges.size()+1];

    Arrays.fill(distance, Integer.MAX_VALUE/2);
    distance[v] = 0;
    dq.add(v);
    while(dq.size()!=0)
    {
      int s = dq.pollFirst();
      // Process node s
      for( Pair u : edges.get(s))
      {
        if(distance[u.to] > distance[s] + u.w)
        {
          distance[u.to] = distance[s] + u.w;
          if (u.w == 0)
              dq.offerFirst(u.to);
          else
              dq.offerLast(u.to);
       }
    }
    
  }
  System.out.println( Arrays.toString(distance));
}

  ///////////////////////////////////// Adjacency List Maker////////////////////////////////////////////////
  public void addNode(int u) {
    if (!edges.containsKey(u)) {
      edges.put(u, new ArrayList<Pair>());
    }
  }
  public void addEdge(int u, int v, int w) {
    addNode(u);
    addNode(v);
    edges.get(u).add(new Pair(v, w));
    edges.get(v).add(new Pair(u, w));
  }

}
class Pair { // utilizing Java "Generics"
  int to;
  int w;

  public Pair(int f, int s) { to = f; w = s; }
  
  public String toString()
  {
      return to + " " + w;
  }
}