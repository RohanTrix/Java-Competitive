import java.util.*;
public class MonotonicQueue {
    public static void main(String[] args) {
        int[] nums = {8, 6, 4, 5, 7};
        MonoQueue monoq = new MonoQueue(nums);
    }
}
class MonoQueue {
    int[] nums, firstSmallerToLeft, firstSmallerToRight, firstLargerToLeft, firstLargerToRight;
    
    public MonoQueue(int nums[])
    {
        this.nums = nums;
        this.firstSmallerToLeft = new int[nums.length];
        this.firstSmallerToRight = new int[nums.length];
        this.firstLargerToLeft = new int[nums.length];
        this.firstLargerToRight = new int[nums.length];
        Arrays.fill(firstSmallerToLeft, -1);
        Arrays.fill(firstSmallerToRight, -1);
        Arrays.fill(firstLargerToLeft, -1);
        Arrays.fill(firstLargerToRight, -1);
        //buildIncreasingQueue();
        //buildDecreasingQueue();
    }
    private void buildIncreasingQueue()
    {
        Deque<Integer> queue = new ArrayDeque<>(); // increasing queue
        int n = nums.length;
        for(int i = 0; i<n; i++)
        {
            while(!queue.isEmpty() && nums[queue.peekLast()]>=nums[i])
            {
                firstSmallerToRight[queue.pollLast()] = nums[i];
            }
            if(!queue.isEmpty())
            {
                firstSmallerToLeft[i] = nums[queue.peekLast()];
            }
            queue.offerLast(i);
        }
    }
    private void buildDecreasingQueue()
    {
        Deque<Integer> queue = new ArrayDeque<>(); // increasing queue
        int n = nums.length;
        for(int i = 0; i<n; i++)
        {
            while(!queue.isEmpty() && nums[queue.peekLast()] <= nums[i])
            {
                firstLargerToRight[queue.pollLast()] = nums[i];
            }
            if(!queue.isEmpty())
            {
                firstLargerToLeft[i] = nums[queue.peekLast()];
            }
            queue.offerLast(i);
        }
    }
}