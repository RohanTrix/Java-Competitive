package DSA.Trees;

import java.util.*;

// REFER AlgoZenith 
public class SegTree {
    long arr[], tree[];

    void solve(Scanner sc) {
        int n = sc.nextInt();
        tree = new long[4 * n + 5];
        arr = new long[n];

        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        buildTree(1, 0, n - 1);
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter array size");
        int n = sc.nextInt();
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        buildTree(1, 0, n - 1);

    }

    static long query(int id, int l, int r, int lquery, int rquery) {
        if (l > rquery || r < lquery) // Our range is entirely outside range
            return 0L;
        if (lquery <= l && r <= rquery) // our range completely inside query range
            return tree[id];

        // Ranges partially overlap
        int mid = (l + r) / 2;
        long left = query(2 * id, l, mid, lquery, rquery);
        long right = query(2 * id + 1, mid + 1, r, lquery, rquery);
        return left ^ right;
    }

    void update(int id, int l, int r, int idx, long val) {
        if (idx < l || idx > r)
            return;
        if (l == r) {
            tree[id] = val;
            arr[idx] = val;
            return;
        }

        int mid = (l + r) / 2;
        update(2 * index, l, mid, idx, val);
        update(2 * index + 1, mid + 1, r, idx, val);
        tree[id] = tree[2 * index] ^ tree[2 * tree + 1];
    }

    void buildTree(int id, int l, int r) {

        /*
         * @param id Index of the current node in Tree
         * 
         * @param l Left boundary current node represents
         * 
         * @param r Right boundary current node represents
         */

        if (l == r) {
            tree[id] = arr[l];
            return;
        }
        int mid = (l + r) / 2;
        build(2 * id, l, mid);
        build(2 * id + 1, mid + 1, r);
        tree[id] = tree[2 * id] ^ tree[2 * id + 1];
    }

}
