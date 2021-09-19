package DSA.Graphs.SCC;
import java.util.*;
// Explanation Refer: https://youtu.be/vLi1X4FG2d0 (Bridges)
//                    https://youtu.be/oxUCKaDtNJA (Articulation Point)
public class Articulation_Point {

    Map<Integer, Set<Integer>> edges = new TreeMap<>();
    HashSet<Integer> visited, articulationPoints;
    ArrayList<Bridge> bridges;
    int time;
    int[] lowlink, ids;
   

    public static void main(String[] args)
    {
        Articulation_Point g = new Articulation_Point();
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
        g.findAP();
        System.out.println("Articulation Points: " + g.articulationPoints);
        System.out.println("Bridges: "+g.bridges);
        sc.close();
    }

    public void findAP() {

        int n = edges.size();
        visited = new HashSet<>();
        articulationPoints = new HashSet<>();
        bridges = new ArrayList<>();
        time = 1;
        lowlink = new int[n+1];
        ids = new int[n+1];
        Arrays.fill(ids, -1);
        Arrays.fill(lowlink, -1);

        for (int u = 1; u <=n; u++)
        {
          if (!visited.contains(u))
          {
              dfs(u, -1);
          }
        }

      }
    void dfs(int at, int parent) {
        lowlink[at] = ids[at] = time++;
        visited.add(at);
        int children = 0;
        for (int to : edges.get(at)) 
        {
            if(to==parent) continue;

            if (visited.contains(to)) 
                lowlink[at] = Math.min(lowlink[at], ids[to]);

            else
            {
                dfs(to, at);
                lowlink[at] = Math.min(lowlink[at], lowlink[to]);
                if(lowlink[to]>= ids[at] && parent!=-1)   // Handles adding articulation point
                    articulationPoints.add(at);           // Handles adding articulation point
                
                if(lowlink[to]>ids[at])                   // Handles adding Brdige Edge
                    bridges.add(new Bridge(at, to));      // Handles adding Bridge Edge
                
                children++;
            }
        }
        if(parent==-1 && children>1)
            articulationPoints.add(at);
    }
  
    
    ///////////////////////////////////// Adjacency List Maker////////////////////////////////////////////////
    public void addNode(int u) {
        if (!edges.containsKey(u)) {
        edges.put(u, new TreeSet<>());
        }
    }
    public void addEdge(int u, int v) {
        edges.get(u).add(v);
        edges.get(v).add(u);
    }
    ///////////////////////////////////// Bridge Edge ////////////////////////////////////////////////////////
    static class Bridge
    {
        int from, to;
        public Bridge(int f, int t)
        {
            from  = f; to = t;
        }
        public String toString()
        {
            return "("+from+","+to+")";
        }

    }
}
