package DSA.NumberTheory;

import java.util.*;

public class Modular_Expo {
    static long mod  = 1000000007L;
    public static void main(String[] args) {
        int A[][] = {{1,2},{3,4}};
        int b = 5;
        int res[][] = matExp(A, b);
        for(int m[]: res) System.out.println(Arrays.toString(m));
    }
    // ----------------------------------a^b using Binary Exponentiation ---------------------------------
    public static long binpow(long a, long b)
    {
        a%=mod;
        long res = 1;
        while(b>0)
        {
            if((b&1)==1)
            {
                res = res * a % mod;
            }
            a = a * a % mod;
            b>>=1;
        }
        return res;
    }
    // ------------------------------------------------------------------------------------

    // ----------------------------------Matrix Exponentiation ---------------------------------
    public static int[][] matExp(int[][] A, int b)
    {
        int n = A.length; 
        int[][] res = new int[n][n];

        // Setting res as Identity Matrix
        for(int i =0; i<n;i++)
            res[i][i] = 1;

        while(b>0)
        {
            if((b&1)==1)
            {
                res = sqMatMul(res, A);
            }
            A = sqMatMul(A,A);
            b>>=1;
        }
        return res;
    }
    public static int[][] sqMatMul(int[][] A, int[][] B)
    {
        int n = A.length; 
        int[][] res = new int[n][n];

        for(int i =0; i<n; i++)
        {
            for(int j = 0; j<n; j++)
            {
                for(int k = 0; k<n; k++)
                {
                    res[i][j] +=A[i][k]*B[k][j];
                }
            }
        }
        return res;
    }
    // ------------------------------------------------------------------------------------
}
