package DSA.Sorting;
import java.util.Arrays;

public class MergeSort
{
    void merge(int arr[], int l, int m, int r)
    {
         
         int len1 = m-l+1;
         int len2 = r-(m+1)+1;
         
         int leftArr[] = new int[len1];
         int rightArr[] = new int[len2];
         
         for(int i = l; i<=m; i++)
            leftArr[i-l] = arr[i];
         for(int i = m+1; i<=r; i++)
            rightArr[i-(m+1)] = arr[i];
        
        int i = 0, j = 0, k = l;
        
        while(i<len1 && j<len2)
        {
            if(leftArr[i]<rightArr[j])
                arr[k++] = leftArr[i++];
            else
                arr[k++] = rightArr[j++];

        }
        while(i<len1)
            arr[k++] = leftArr[i++];
        while(j<len2)
            arr[k++] = rightArr[j++];
         
    }
    void mergeSort(int arr[], int l, int r)
    {
        if(l>=r)return;
        int mid = l + (r-l)/2;
        mergeSort(arr,l, mid);
        mergeSort(arr,mid+1,r);
        merge(arr,l,mid,r);
        //code here
    }
    public static void main(String args[])
    {
        MergeSort ob = new MergeSort();
        int arr[] =  {9,8,7,6,5,4,3,2,1,0};
        System.out.println(Arrays.toString(arr));
        int len = arr.length;
        ob.mergeSort(arr, 0, len-1);
        System.out.println(Arrays.toString(arr));
    }
}