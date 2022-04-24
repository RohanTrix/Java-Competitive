public class LIS {
    public static void main(String[] args) {
        int list[] = {1,5,2,2,3,4,3,4};
        LIS ob = new LIS();
        System.out.println(ob.slowLIS(nums));
        System.out.println(ob.fastLIS(nums));

    }
    // N^2 DP LIS
    public int slowLIS(int[] nums) {
        int size = nums.length;
        int dp[] = new int[nums.length];
        Arrays.fill(dp, 1);
        for(int i =1; i<size;i++)
        {
            for(int j = 0; j<i; j++)
            {
                if(nums[i]>nums[j])
                    dp[i] = Math.max(dp[i],dp[j]+1); 
            }
        }
        int maxi = -1;
        for(int i:dp) maxi = Math.max(i,maxi);
        return maxi;
    }
    // Binary Search LIS
    public int fastLIS(int[] nums) // REFER ALGO ZENITH{
        ArrayList<Integer> sol = new ArrayList<>();
        for(int  currNum: nums)
        {
            if(sol.size()==0 || currNum > sol.get(sol.size()-1))
            {
                sol.add(currNum);
            }
            else
            {
                int pos = upper_bound(sol, currNum);
                sol.set(pos,currNum);
            }
        }
        return sol.size();
    }
    int upper_bound(ArrayList<Integer> arr, int key)
    {
        // Largest value less than or equal to key
        int left = 0, right = arr.size()-1;
        int pos = -1;
        while(left<=right)
        {
                int mid = left +(right-left)/2;
                if(arr.get(mid) >= key)
                {
                    pos = mid;
                    right = mid - 1;
                }
                else
                    left = mid + 1;
        }
        return pos;
    }
    
}
