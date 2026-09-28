package session_4.AP;

public class MaximumSubarray {
    public static int maxSubArray(int[] nums) {
        int currentSum = nums[0];
        int largestSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (currentSum + nums[i] > nums[i]) {
                currentSum = currentSum + nums[i];
            } else {
                currentSum = nums[i];
            }

            if (currentSum > largestSum) {
                largestSum = currentSum;
            }
        }
        return largestSum;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(nums));
    }
}