package session_4.AP;

import java.util.HashMap;

public class SubarraySumEqualsK {
    public static int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> prefixCounts = new HashMap<>();
        prefixCounts.put(0, 1);

        int currentSum = 0;
        int answer = 0;

        for (int i = 0; i < nums.length; i++) {
            currentSum = currentSum + nums[i];

            if (prefixCounts.containsKey(currentSum - k)) {
                answer = answer + prefixCounts.get(currentSum - k);
            }

            if (prefixCounts.containsKey(currentSum)) {
                prefixCounts.put(currentSum, prefixCounts.get(currentSum) + 1);
            } else {
                prefixCounts.put(currentSum, 1);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1};
        System.out.println(subarraySum(nums, 2));
    }
}