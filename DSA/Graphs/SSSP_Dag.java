package Graphs;
import java.util.*;
@SuppressWarnings("rawtypes")
public class SSSP_Dag {
  // Works on a DAG even with negative edge weights
  // Adjaceny List
  public Map<Integer, Set<pair>> edges = new TreeMap<>();
  // Visited Set
  public static Set<Integer> visited = new HashSet<Integer>();
  //Topological Ordering
  public static ArrayDeque<Integer> stack = new ArrayDeque<Integer>();

  public static void main(String[] args)
  {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the number of nodes:");
    int n = sc.nextInt();
    System.out.println("Enter the number of edges:");
    int m = sc.nextInt();
    SSSP_Dag g = new SSSP_Dag();
    for(int i =1; i<=n;i++)
      g.addNode(i);

    for(int i =0; i< m;i++)
      g.addEdge(sc.nextInt(), sc.nextInt(), sc.nextLong());
    
    
    System.out.println("Enter the starting node:");
    int s = sc.nextInt();
    Long sssp[] = g.dagShortestPath(n,s);
    System.out.println(Arrays.toString(sssp));

    //System.out.println(g.edges);
    sc.close();
  }
  static class pair<neighbour,weight> implements Comparable < pair<neighbour,weight> >
    {
        int neighbour;
        long weight;
        pair(int i, long j) {
            neighbour = i;
            weight = j;
        }
        public int compareTo(pair p) {
            return Long.compare(this.weight,p.weight);
            
        }
    }
  Long[] dagShortestPath(int numNodes, int start)
  {
    Long dist[] = new Long[numNodes+1];
    Arrays.fill(dist, null);
    dist[start] = (long) 0;
    for(int nodeIndex : stack)
    {

        if( dist[nodeIndex] != null)
        {
          Set<pair> adjacentEdges = edges.get(nodeIndex);
          if( adjacentEdges.size()!=0)
          {
            for( pair edge : adjacentEdges)
            {
                long newDist = dist[nodeIndex] + edge.weight;
                if( dist[edge.neighbour] == null) 
                  dist[edge.neighbour] = newDist;
                else
                dist[edge.neighbour] = Math.min(dist[edge.neighbour], newDist);
            }
          }
        }
    }
      return dist;
  }
  public void addNode(int u) {
    if (!edges.containsKey(u)) {
      edges.put(u, new TreeSet<pair>());
    }
  }
  public void addEdge(int u, int v, long w) {
    edges.get(u).add(new pair(v,w));
    //edges.get(v).add(u);
  }
}