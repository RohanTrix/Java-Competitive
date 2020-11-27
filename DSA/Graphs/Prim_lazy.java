
import java.util.*;

@SuppressWarnings("unchecked")
public class Prim_lazy {
  // Adjaceny List
  public Map<Integer, Set<Edge>> edges = new TreeMap<>();
  // Visited Set
  public static Set<Integer> visited = new HashSet<Integer>();
  //MST Edge list
  public static Map<Integer, Edge> hm = new HashMap<>();
  // Priority Queue for Edges
  public static PriorityQueue<Edge> pq = new PriorityQueue<>();
  public static void main(String[] args)
  {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the number of nodes:");
    int n = sc.nextInt();
    System.out.println("Enter the number of edges:");
    int m = sc.nextInt();
    Prim_lazy g = new Prim_lazy();
    for(int i =0; i< m;i++)
    {
      g.addEdge(sc.nextInt(), sc.nextInt(), sc.nextLong());
    }
    long res = g.lazyPrims(0, n);
    System.out.println(hm);
    System.out.println(res);


    // System.out.println(g.edges);
    sc.close();
  }
  public long lazyPrims(int s, int numNodes)
  {
    int m = numNodes-1;
    long edgeCount = 0, mstCost = 0;
    addPQ(s);

    while( !pq.isEmpty() && edgeCount !=m )
    {
      Edge latestEdge = pq.poll();
      int nodeIndex = latestEdge.x;
      if( visited.contains(nodeIndex))
        continue;
      hm.put(nodeIndex, latestEdge);
      edgeCount++;
      mstCost += latestEdge.weight;
      
      addPQ(nodeIndex);
    }
      if( edgeCount !=m)
        return 0;
      
      return mstCost;
    

    }
  
  public void addPQ(int nodeIndex)
  {
    visited.add(nodeIndex);
    
    for( Edge e : edges.get(nodeIndex))
      if( !visited.contains(e.x))
        {
          pq.add(e);
        }
  }
  public void addNode(int u) {
    if (!edges.containsKey(u)) {
      edges.put(u, new TreeSet<Edge>());
    }
  }
  public void addEdge(int u, int v, long w) {
    addNode(u);
    addNode(v);
    edges.get(u).add(new Edge(v, w));
    edges.get(v).add(new Edge(u, w));
  }
}
class Edge implements Comparable<Edge>{
  int x;
  long weight;

  public Edge(int f, long val) { x = f; weight = val;}
  public int compareTo(Edge e)
  {
      return Long.compare(this.weight, e.weight);
  }
}