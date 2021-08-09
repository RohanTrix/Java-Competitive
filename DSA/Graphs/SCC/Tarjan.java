import java.util.*;

public class Tarjan {

    Map<Integer, Set<Integer>> edges = new TreeMap<>();
    HashSet<Integer> visited;
    Stack<Integer> stack;
    int time;
    int[] lowlink, ids;
    List<List<Integer>> components;

    public static void main(String[] args)
    {
        Tarjan g = new Tarjan();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Number of Nodes: ");
        int n = sc.nextInt();
        for(int i = 1; i<=n; i++) g.addNode(i);
        
        System.out.println("Enter Number of Edges: ");
        int m = sc.nextInt();
        
        for(int i =0; i<m;i++)
        {
            g.addEdge(sc.nextInt(), sc.nextInt());
        }
        g.scc();
        System.out.println(g.components);
        
    }

    public void scc() {

        int n = edges.size();
        visited = new HashSet<>();
        stack = new Stack<>();
        time = 1;
        lowlink = new int[n+1];
        ids = new int[n+1];
        components = new ArrayList<>();
        Arrays.fill(ids, -1);

        for (int u = 1; u <=n; u++)
        {
          if (ids[u]==-1)
            dfs(u);
        }
      }

    void dfs(int at) {
        lowlink[at] = ids[at] = time++;
        visited.add(at);
        stack.add(at);
        
    
        for (int to : edges.get(at)) 
        {  
            if (ids[to] == -1)
              dfs(to);

            if (visited.contains(to)) 
            {
                if(lowlink[at] > lowlink[to])
                lowlink[at] = lowlink[to];
            }
        }

        if (ids[at] == lowlink[at]) 
        {
            List<Integer> component = new ArrayList<>();
            while (true)
            {
                int x = stack.pop();
                component.add(x);
                visited.remove(x);
                if (x == at) break;
            }
            components.add(component);
        }
        //System.out.println(at);
        
        
    }
    ///////////////////////////////////// Adjacency List Maker////////////////////////////////////////////////
    public void addNode(int u) {
        if (!edges.containsKey(u)) {
        edges.put(u, new TreeSet<>());
        }
    }
    public void addEdge(int u, int v) {
        edges.get(u).add(v);
    }
}
