import java.util.*;

/* 
    The idea is to solve the SCC problem in one DFS:

    1. We have an array ids which stores at what unit of time(ID of node)
       that node i was visited for first time
    
    2. Visited Set contains elements which have been visited during current DFS.

    3. Lowlink array stores the lowest ID of node from which we can reach node i.
       This eventually stores the ID of leader(first visited) component of the SCC.
    
    4. We maintain a stack during dfs as the elements occuring in one SCC will stay
       adjacent to each other with the leader of the SCC at the lowest position among them.
    
    Procedure:
       1. Init the variables and DS.
       2. For every node which is not explored(ID=-1), we call a DFS from it.
       3. In DFS of node `at`, we set LowLink = ID = time, visit it and add to stack.
       4. For each neighbour `to` of `at`, if `to` has never been explored, we call DFS(to)
       5. After this DFS is over, we check if it is in visited set(denoting whether it is 
          in the current SCC being created).
       6. If yes, we update its low link value to low link of the node it is going to
       7. Finally we check, if the node `at` is the leader node of a SCC( same ID and Low Link)
          If it is, we keep popping elements from the stack and add it to a SCC List until 
          we have popped the leader from the stack.
        8. We finally add this SCC list to our final result. 

*/



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
        sc.close();
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
