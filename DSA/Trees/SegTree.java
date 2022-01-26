package DSA.Trees;

import java.util.*;

// REFER AlgoZenith 
public class SegTree
{
    static int arr[] = new int[100100];
    static int tree[] = new int[400400];
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter array size");
        int n = sc.nextInt();
        for(int i = 0; i<n; i++) arr[i] = sc.nextInt();

        buildTree(1, 0, n-1,);
        
    }

    static int query(int index, int l, int r, int lquery, int rquery)
    {
        if(l>rquery || lquery > r) 
            return 0;
        if(lquery<=l && r<=rquery)
            return tree[index];
        
        int mid = (l+r)/2;
        int leftAns = query(2*index, l, mid, lquery, rquery);
        int rightAns = query(2*index+1, mid+1, r, lquery, rquery);
        return leftAns+rightAns;
    }
    static void update(int index, int l, int r, int pos, int val)
    {
        /* 
         * @param index Index of the current node in Tree
         * @param l     Left boundary current node represents
         * @param r     Right boundary current node represents
         * @param pos   Index of val in actual array
         * @param val   Value to be replaced at pos position
         */
        if(pos<l || pos>r) return;
        if(l == r)
        {
            tree[index] = val;
            arr[l] = val;
            return;
        }
        
        int mid = (l+r)/2;
        update(2*index, l, mid, pos, val);
        update(2*index+1, mid + 1, r, pos, val);
        tree[index] = tree[2*index] + tree[2*tree + 1];
    }
    static void buildTree(int index, int l, int r){

        /* 
         * @param index Index of the current node in Tree
         * @param l     Left boundary current node represents
         * @param r     Right boundary current node represents
         */

        if(l == r)
        {
            tree[index] = arr[l];
            return;
        }
        int mid = (l+r)/2;
        buildTree(2*index, l, mid);
        buildTree(2*index+1, mid + 1, r);
        tree[index] = tree[2*index] + tree[2*tree + 1];
    }

}
