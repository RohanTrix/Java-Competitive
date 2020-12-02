package Trees;

import java.util.*;
import java.util.stream.IntStream;
// Minimum Segment Tree
public class SegTree
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter array size");
        int n = sc.nextInt();
        int arr[] = new int[n];
        IntStream.range(0,n).forEachOrdered(i -> arr[i] = sc.nextInt()); // Taking Array input


        int tree[] = new int[4*n +1];
        buildTree(arr, 0, n-1, tree, 1);
        int left = sc.nextInt();
        int right = sc.nextInt();
        int res = query(tree,0,n-1, left, right,1);
        System.out.println(res);
        sc.close();

    }

    static int query(int tree[], int ts, int te, int qs, int qe, int index)
    {
        /* 
         * @param tree Array containing the Segment Tree;
         * @param ts   Start index of Node's range in Tree
         * @param te   End index of Node's range in Tree
         * @param qs   Start index of query in Array
         * @param qe   End index of query in Array
         * @param index Index of the current node in Tree
         */

        // CASE: COMPLETE OVERLAP
        if(ts<=qs && te>=qe )
            return tree[index];

        // CASE: NO OVERLAP
        if(qe<ts || qs > te)
            return Integer.MAX_VALUE;
        
        // CASE : PARTIAL OVERLAP
        int mid = (ts+te)/2;
        int leftAns = query(tree, ts, mid, qs, qe, 2*index);
        int rightAns = query(tree, mid+1, te, qs, qe, 2*index+1);
        return Math.min(leftAns, rightAns);



    }
    static void buildTree(int a[], int s, int e, int tree[], int index){
        
        if( s==e){

            tree[index] = a[s];
            return;
        }
        else
        {
            //Rec Case
            int mid = (s+e)/2;
            buildTree(a, s, mid, tree, 2*index); //LEFT SUB TREE CALL
            buildTree(a, mid+1, e, tree, 2*index+1); // RIGHT SUBTREE CALL
            tree[index] = Math.min(tree[2*index], tree[2*index+1]);
            return;
        }

    }

}
