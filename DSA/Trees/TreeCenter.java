package DSA.Trees;
import java.util.*;

public class TreeCenter
{
    // REFER : https://youtu.be/nzF_9bjDzdc
    Map<Integer, Set<Integer>> edges = new HashMap<>();
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        TreeCenter ob = new TreeCenter();
        System.out.println("Enter the number of nodes: ");
        int n = sc.nextInt();
        for(int i =1; i<=n; i++) ob.addNode(i);

        System.out.println("Enter the number of edges: ");
        int m = sc.nextInt();
        
        for(int i = 0; i<m; i++)
        {
            ob.addEdge(sc.nextInt(), sc.nextInt());
        }
        ArrayList<Integer> res = ob.findCenter();
        System.out.println(res);
        sc.close();
    }
    public ArrayList<Integer> findCenter()
    {
        int n = edges.size();
        int indeg[] = new int[n+1];
        ArrayList<Integer> leaves = new ArrayList<>();
        for(int i = 1; i<=n; i++)
        {
            indeg[i] = edges.get(i).size(); // Setting InDegree
            if(indeg[i] < 2) // Single Node or Leaf Node
            {
                leaves.add(i);
                indeg[i] = 0;
            }
        }
        int count = leaves.size();
        while(count<n)
        {
            ArrayList<Integer> new_leaves = new ArrayList<>();
            for(int leaf : leaves)
            {
                for(int to : edges.get(leaf))
                {
                    indeg[to]-=1;
                    if(indeg[to]==1)
                        new_leaves.add(to);
                }
                // indeg[leaf] = 0; Line no necessary
            }
            count+=new_leaves.size();
            leaves = new ArrayList<>(new_leaves);
        }
        return leaves;
    }
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