package Searching;

public class Binary_Search {
    boolean possible()
    {
      return true;
    }
    int binarySearch(int[] nums, int target){
        if(nums == null || nums.length == 0)
          return -1;
      
        int left = 0;
        int right = nums.length - 1;

        int bestAns = -1;
        while(left <= right){
         
          int mid = left + (right - left) / 2;
          if(possible())
            {
              bestAns = mid;
              right = mid-1;
            }
          else 
              left = mid + 1; 
        }
      
        return bestAns;
      }
}
