public class MaxSumSubarray {
    public static int maxSumSubarray(int[] nums, int k) {
        int n = nums.length;
        if (n < k) {
            System.out.println("Invalid Input");
            return -1;
        }

        int windowSum = 0;
        // Calculate sum of the first window of size k
        for (int i = 0; i < k; i++) {
            windowSum += nums[i];
        }

        int maxSum = windowSum;
        // Slide the window to the right and update the sum
        for (int i = k; i < n; i++) {
            windowSum += nums[i] - nums[i - k];
            maxSum = Math.max(maxSum, windowSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = {1, 4, 2, 10, 2, 3, 1, 0, 20};
        int k = 4;
        int result = maxSumSubarray(nums, k);
        System.out.println("Maximum Sum of Subarray of Size " + k + ": " + result);
    }
}
