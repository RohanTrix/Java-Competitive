import java.util.*;
public class Bellman_Ford {
    Set<pair> edges = new HashSet<>();
    int INT_MAX = Integer.MAX_VALUE/2;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of nodes:");
        int n = sc.nextInt();
        System.out.println("Enter the number of edges:");
        int m = sc.nextInt();
        Bellman_Ford g = new Bellman_Ford();
        // for (int i = 1; i <= n; i++)
        //     g.addNode(i);

        // Storing Edge List in edges
        for (int i = 0; i < m; i++)
            g.addEdge(sc.nextInt(), sc.nextInt(), sc.nextLong());

        System.out.println("Enter the starting node:");
        int s = sc.nextInt();
        
        System.out.println(Arrays.toString(g.bellman_ford(n, s)));
    }

    public long[] bellman_ford(int numNodes, int start)
    {
        long dist[] = new long[numNodes+1];
        Arrays.fill(dist, INT_MAX);
        dist[start] = 0;
        for(int i = 1; i<numNodes;i++)
        {
            for(pair tmp : edges)
            {
                if(dist[tmp.from] != INT_MAX && dist[tmp.to] > dist[tmp.from] + tmp.weight)
                    dist[tmp.to] = dist[tmp.from] + tmp.weight;
            }
        }

        for(pair tmp: edges)
        {
            if(dist[tmp.to] > dist[tmp.from] + tmp.weight)
                System.out.println("Negative Cycle Exists!");
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