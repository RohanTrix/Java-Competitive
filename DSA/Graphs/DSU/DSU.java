package DSA.Graphs.DSU;
import java.util.*;
class DSU 
{
    public int parent[];
    public int rank[];
    public DSU(int num)
    {
        parent = new int[num];
        rank = new int[num];
        Arrays.fill(rank,1);
        Arrays.fill(parent,-1);
    }
    public int find( int i)
    {
        if(parent[i]== -1)
        {
            return i;
        }
        return parent[i] = find(parent[i]); // Path Compression
    }
    public boolean union(int a, int b)
    {
        int s1 = find(a);
        int s2 = find(b);
        if( s1!= s2)
        {
            if( rank[s1] < rank[s2] )
            {
                parent[s1] = s2;
                rank[s2] += rank[s1];
            }
            else
            {
                parent[s2] = s1;
                rank[s1] += rank[s2]; 
            }
            return true;
        }
        return false;
    }
}
