package DSA.PrefixSum;
import java.util.*;
public class PrefixSum2D {
    public static void main(String args[])
    {
        int mat[][] = {{8,1,4,6,4}, 
                       {8,5,3,9,2},
                       {3,8,0,6,7},
                       {3,7,2,3,6},
                       {9,5,3,5,5}};
        int n = mat.length, m = mat[0].length;
        int pref[][] = new int[n+1][m+1];
        for(int i  = 0;i<=n;i++) pref[i][0] = 0;
        for(int i  = 0;i<=m;i++) pref[0][i] = 0;
        for(int i = 1; i<=n;i++)
        {
            for(int j = 1; j<=m;j++)
            {
                pref[i][j] = pref[i-1][j] + pref[i][j-1] - pref[i-1][j-1] + mat[i-1][j-1];
            }
        }

        
    }
    public void viewArray2D(int arr[][])
    {
        for (int[] row: arr)
        System.out.println(Arrays.toString(row));
    }
}
