import java.util.*;
// LOGIC: https://youtu.be/dYIWheKq5Xc

class Edge implements Comparable<Edge>
    {
        int x, y, weight;
        public Edge(int xx, int yy, int w)
        {
            x = xx;
            y = yy;
            weight = w;
        }
        public int compareTo(Edge p)
        {
            return this.weight - p.weight;
        }
        public String toString()
        {
            return x+" "+y+" "+weight;
        }
    }
public class Kruskal {
    public int parent[];
    public int rank[];
    public ArrayList<Edge> res;
    public ArrayList<Edge> edges = new ArrayList<>();
    public Kruskal(int num)
    {
        parent = new int[num+1];
        Arrays.fill(parent, -1);
        rank = new int[num+1];
        Arrays.fill(rank,1);
        res = new ArrayList<>();
    }
    public static void main(String args[])
    {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of edges: ");
        int n = sc.nextInt();
        Kruskal ob = new Kruskal(n);
        for(int i =0; i< n;i++)
        {
            ob.edges.add(new Edge(sc.nextInt(), sc.nextInt(), sc.nextInt()));
        }
        Collections.sort(ob.edges);

        for(int i = 0; i<n; i++)
        {
            int x = ob.edges.get(i).x;
            int y = ob.edges.get(i).y;
            
            if(ob.DSUfind(x)!=ob.DSUfind(y))
            {
                ob.res.add(ob.edges.get(i));
                ob.DSUunion(x, y);
            }
        }
        System.out.println(ob.res);
    }

    public int DSUfind(int i)
    {
        if(parent[i]==-1)
            return i;
        parent[i] = DSUfind(parent[i]);
        return parent[i];
    }
    public void DSUunion(int a, int b)
    {
        int s1 = DSUfind(a);
        int s2 = DSUfind(b);
        if(rank[s1]<rank[s2])
        {
            parent[s1] = s2;
            rank[s2]+=rank[s1];
        }
        else
        {
            parent[s2] = s1;
            rank[s1]+=rank[s2];
        }
    }
}
