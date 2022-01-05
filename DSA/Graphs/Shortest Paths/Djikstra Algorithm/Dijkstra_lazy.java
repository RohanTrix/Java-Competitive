package Graphs;

import java.util.*;
@SuppressWarnings("rawtypes")
public class Dijkstra_lazy {
  // Works on a DAG even with negative edge weights
  // Adjaceny List
  public Map<Integer, Set<pair>> edges = new TreeMap<>();
  // Visited Set
  public static Set<Integer> visited = new HashSet<Integer>();
  //Topological Ordering
  public static ArrayDeque<Integer> stack = new ArrayDeque<Integer>();
  // Array storing which nodes come before ith node in shortest path from starting node
  public static int prev[];

  public static void main(String[] args)
  {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the number of nodes:");
    int n = sc.nextInt();
    System.out.println("Enter the number of edges:");
    int m = sc.nextInt();
    Dijkstra_lazy g = new Dijkstra_lazy();
    for(int i =1; i<=n;i++)
      g.addNode(i);

    for(int i =0; i< m;i++)
      g.addEdge(sc.nextInt(), sc.nextInt(), sc.nextLong());
    System.out.println("Enter the starting node:");
    int s = sc.nextInt();
    //Long distArray[] = g.dijkstra_lazy(n,s);
    //System.out.println("Distance Array: " + Arrays.toString(distArray));

    int e = n; // taking the ending node for the path to be nth Node(last node)

    System.out.println("Shortest Path Array: \n");
    g.findShortestPath(n, s, e);
    //System.out.println(g.edges);
    sc.close();
  }

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////

  Long[] dijkstra_lazy(int numNodes, int start)
  {
      prev = new int[numNodes+1];
      Arrays.fill(prev, -1);
      Long newDist = null;
      Long dist[] = new Long[numNodes+1];
      Arrays.fill(dist, Long.MAX_VALUE);
      dist[start] = (long) 0;

      PriorityQueue<pair> pq = new PriorityQueue<>();
      pq.add(new pair(start,0));
      while(pq.size()!=0)
      {
          pair currNode = pq.poll();
          visited.add(currNode.neighbour);
          if( dist[currNode.neighbour] < currNode.weight )
            continue;

          for( pair edge : edges.get(currNode.neighbour))
          {
                if(visited.contains(edge.neighbour))
                    continue;
                newDist = dist[currNode.neighbour] + edge.weight;
                
                if( newDist < dist[edge.neighbour])
                {
                    prev[edge.neighbour] = currNode.neighbour;
                    dist[edge.neighbour] = newDist;
                    pq.add(new pair(edge.neighbour, newDist));
                }

          }
          //if(currNode.neighbour==endNode) return dist[endNode];
      }
    return dist;
    }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    void findShortestPath(int numNodes, int start, int end)
    {
      Long dist[] = dijkstra_lazy(numNodes, start);
      Stack<Integer> path = new Stack<>();
      if(dist[end] == Long.MAX_VALUE)
        System.out.println("No path");
      
      for(int curr = end; curr!= -1; curr = prev[curr])
          path.push(curr);
      
      while(path.size()!=0)
          System.out.print(path.pop()+ " ");
    }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
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
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////

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