import java.util.*;
public class LCA {
    Map<Integer, Set<Integer>> edges = new HashMap<>();
    int parent[][];
    int depth[];
    public static void main(String[] args) {
        LCA ob  = new LCA();
        // GRAPH CREATION : START
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of nodes: ");
        int n = sc.nextInt();
        for(int i =0; i<n; i++) ob.addNode(i);

        System.out.println("Enter the number of edges: ");
        int m = sc.nextInt();
        
        for(int i = 0; i<m; i++)
        {
            ob.addEdge(sc.nextInt(), sc.nextInt());
        }
        // GRAPH CREATION : END

        ob.parent = new int[n][20];
        ob.depth = new int[n];
        System.out.println(ob.lca(sc.nextInt(),sc.nextInt()));
    }
    int lca(int u, int v)
    {
        if(depth[u]<depth[v])
        {
            int temp = depth[u];
            depth[v] = depth[u];
            depth[u] = temp;
        }
        for(int i = 19; i>=0; i--)
        {
            if(((depth[u]-depth[v]) & (1<<i))>0)
            {
                u = parent[u][i];
            }
        }
        if(u==v) return u;
        for(int i =19; i>=0; i--)
        {
            if(parent[v][i]!=parent[u][i])
            {
                v = parent[v][i];
                u = parent[u][i];
            }
        }
        return parent[u][0];
    }
    void dfs(int node, int prev, int dep)
    {
        parent[node][0] = prev;
        depth[node] = dep;
        for(int i=1; i<20; i++)
        {
            if(parent[node][i-1]!=-1)
            parent[node][i] = parent[parent[node][i-1]][i-1]; // 2^i breaks to 2^(i-1) and 2^(i-1)
            else
            parent[node][i]  = -1;
        }
        for(int to : edges.get(node))
        {
            if(to!=prev)
                dfs(to, node, dep+1);
        }
    }
    /////////////////////////////////////////// ADJ LIST ///////////////////////////////////////////
    public void addNode(int u)
    {
        if(!edges.containsKey(u))
            edges.put(u, new TreeSet<>());
    }
    public void addEdge(int u, int v)
    {
        edges.get(u).add(v);
        edges.get(v).add(u);
    }
}
