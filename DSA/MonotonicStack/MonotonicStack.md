# Monotonic Stack
```java
import java.util.*;
class Main {
  public static void main(String[] args) {
        int[] nums = {8, 6, 4, 5, 7};
        MonotonicStack monotonicStack = new MonotonicStack(nums);
        System.out.println("FirstSmaller to Left :" + Arrays.toString(monotonicStack.getFirstSmallerToLeft()));
        System.out.println("FirstSmaller to Right :" + Arrays.toString(monotonicStack.getFirstSmallerToRight()));
        System.out.println("FirstLarger to Left :" + Arrays.toString(monotonicStack.getFirstLargerToLeft()));
        System.out.println("FirstLarger to Right :" + Arrays.toString(monotonicStack.getFirstLargerToRight()));
  }
}
class MonotonicStack {
    int[] nums, firstSmallerToLeft, firstSmallerToRight, firstLargerToLeft, firstLargerToRight;

    public MonotonicStack(int[] nums) {
        this.nums = nums;
        this.firstSmallerToLeft = new int[nums.length];
        this.firstSmallerToRight = new int[nums.length];
        this.firstLargerToLeft = new int[nums.length];
        this.firstLargerToRight = new int[nums.length];
        Arrays.fill(firstSmallerToLeft, -1);
        Arrays.fill(firstSmallerToRight, -1);
        Arrays.fill(firstLargerToLeft, -1);
        Arrays.fill(firstLargerToRight, -1);
        buildIncreasingStack();
        buildDecreasingStack();
    }

    private void buildIncreasingStack() {
        int n = nums.length;
        Deque<Integer> stack = new ArrayDeque<>(n);
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && (nums[stack.peek()] >= nums[i])) {
                firstSmallerToRight[stack.poll()] = nums[i];
            }
            if (!stack.isEmpty()) {
                firstSmallerToLeft[i] = nums[stack.peek()];
            }
            stack.push(i);
        }
    }

    private void buildDecreasingStack() {
        int n = nums.length;
        Deque<Integer> stack = new ArrayDeque<>(n);
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && (nums[stack.peek()] <= nums[i])) {
                firstLargerToRight[stack.poll()] = nums[i];
            }
            if (!stack.isEmpty()) {
                firstLargerToLeft[i] = nums[stack.peek()];
            }
            stack.push(i);
        }
    }

    public int[] getFirstSmallerToLeft() {
        return this.firstSmallerToLeft;
    }

    public int[] getFirstSmallerToRight() {
        return this.firstSmallerToRight;
    }

    public int[] getFirstLargerToLeft() {
        return this.firstLargerToLeft;
    }

    public int[] getFirstLargerToRight() {
        return this.firstLargerToRight;
    }
}
```