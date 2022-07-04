import java.util.*;
public class FenwickTree {

    int size;
    int table[];
    public FenwickTree(int size)
    {
        table = new int[size];
        this.size = size;
    }
    // Update Value at i
    void update(int i, int val)
    {
        while(i < size)
        {
            table[i]+=val;
            i += Integer.lowestOneBit(i);
        }
    }
    // Compute prefix sum value [1,i]
    void sum(int i)
    {
        int sum = 0;
        while (i>0)
        {
            sum+=table[i];
            i-=Integer.lowestOneBit(i);
        }
        return sum;
    }
    // Cimpute sum values from [i,j]
    void rangeSum(int l, int r)
    {
        sum(r) - sum(l);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        FenwickTree ft = new FenwickTree(size);
    }
}
