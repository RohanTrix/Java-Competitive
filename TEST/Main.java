
import java.util.*;
import java.util.stream.*;
public class Main {

    // REFER : https://youtu.be/R0Srbd5ALN8

    Set<pair> edges = new HashSet<>();
    int INT_MAX = Integer.MAX_VALUE/2;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //System.out.println("Enter the number of nodes:");
        int n = sc.nextInt();
        //System.out.println("Enter the number of edges:");
        int m = sc.nextInt();
        Main g = new Main();
        

        // Storing Edge List in edges
        for (int i = 0; i < m; i++)
            g.addEdge(sc.nextInt()-1, sc.nextInt()-1, -1);
        long mini = Long.MAX_VALUE/2;
        for(long a[]: g.floyd_warshall(n)) mini = LongStream.of(a).min().getAsLong();
        System.out.println(-mini);
    }

    public long[][] floyd_warshall(int numNodes)
    {
        long dist[][] = new long[numNodes][numNodes];
        for(long a[]: dist) Arrays.fill(a, INT_MAX);

        for(int i =0; i<numNodes; i++) 
            dist[i][i] = 0;
        
        for(pair edge : edges)
            dist[edge.from][edge.to] = edge.weight;
        
        for(int k = 0;k<numNodes; k++)
        {
            for(int i =0; i<numNodes; i++)
            {
                for(int j = 0; j<numNodes; j++)
                {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k]+dist[k][j]);
                }
            }
        }
        return dist;


       
    }
    // public void addNode(int u) {
    //     if (!edges.containsKey(u)) {
    //         edges.put(u, new TreeSet<pair>());
    //     }
    // }

    public void addEdge(int u, int v, long w) {
        edges.add(new pair(u, v, w));
        // edges.get(v).add(u);
    }

    static class pair<from,to,weight> implements Comparable<pair<from,to,weight>> {
        int from, to;
        long weight;
        public pair(int i, int j , long w) {
            from = i;
            to = j;
            weight = w;
        }
        
        @Override
        public int compareTo(pair p) {
            return Long.compare(this.weight, p.weight);
        }
        
        @Override
        public boolean equals(Object obj) {
            pair p = (pair)obj;
            return p.from==from&&p.to==to&&p.weight==weight;
        };
    }
}
