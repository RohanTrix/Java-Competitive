package DSA.Trees;
import java.util.*;
public class TreeDiameter {
    // 2 times DFS approach
    Map<Integer, Set<Integer>> edges = new HashMap<>();
    HashSet<Integer> visited = new HashSet<>();
    int maxlen = -1, maxNode = -1;
    public static void main(String[] args) {

        TreeDiameter ob = new TreeDiameter();
        Scanner sc = new Scanner(System.in);
        // GRAPH CREATION : START
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
        ob.dfs(0,1);
        int start = ob.maxNode;
        ob.maxlen = -1; ob.visited.clear();
        ob.dfs(ob.maxNode, 1);
        int end = ob.maxNode;
        System.out.println("Diameter Length : "+ob.maxlen);
        System.out.println("Path from "+start+" to "+end);
        sc.close();

    }
    public void dfs(int node, int d)
    {
        if(visited.contains(node)) return;
        visited.add(node);

        if( d > maxlen )
        {
            maxNode = node;
            maxlen = d;
        }
        for(int to : edges.get(node))
            dfs(to, d+1);
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