package Graphs;
public class DSU 
{
    public static int parent[];

    public DSU(int num)
    {
        parent = new int[num];
    }
    public int find( int i)
    {
        if(parent[i]== -1)
        {
            return i;
        }
        return find(parent[i]);
    }
    public void union(int a, int b)
    {
        int s1 = find(a);
        int s2 = find(b);
        if( s1!= s2)
        {
            parent[s2] = s1;
        }
    }
}
