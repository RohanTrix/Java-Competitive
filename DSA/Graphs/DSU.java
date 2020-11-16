package Graphs;
public class DSU 
{
    public static int parent[];
    public static int rank[];
    public DSU(int num)
    {
        parent = new int[num];
        rank = new int[num];
        Arrays.fill(rank,1);
    }
    public int find( int i)
    {
        if(parent[i]== -1)
        {
            return i;
        }
        parent[i] = find(parent[i]); // Path Compression
        return parent[i];
    }
    public void union(int a, int b)
    {
        int s1 = find(a);
        int s2 = find(b);
        if( s1!= s2)
        {
            if( rank[s1] > rank[s2] )
            {
                
            }
            parent[s2] = s1;
            rank[s2]
        }
    }
}
